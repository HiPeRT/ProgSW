using AutoMapper;
using Controllers;
using Dto;
using Helpers;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Model;
using Moq;
using Repositories;
using Tests.Factories;
using Tests.Mocks;

namespace Tests
{
    /// <summary>
    /// Test MySvc both with HttpClient (e.g., implementing a real Http call) and with direct Fn call.
    /// The version with Http call has await/async semantics, which I haven't explained in the course.
    /// We also have a third variant using the Moq library.
    /// </summary>
    [TestClass]
    public sealed class MySvcTests
    {
        // Here we don't mock the Mapper
        private IMapper _mapper = default!;

        // Test data (this could also be in another "TestData" static class)
        private const int ValidId = 11;
        private static MySvcPostPayload ValidPayload = new MySvcPostPayload
        {
            Age = "43"
        };

        private static string BuildRequestUrl(int? id)
        {
            return "/mysvc" + (id.HasValue ? $"?id={id}" : "");
        }

        /// <summary>
        /// Common inits for tests
        /// </summary>
        [TestInitialize]
        public void TestInitialize()
        {
            // In these tests we use a fully working automapper
            _mapper = new MapperConfiguration(cfg => { cfg.AddProfile<AutoMapperProfile>(); }).CreateMapper();
        }

        /// <summary>
        /// Test full Http request to URL endpoint. This versin uses my handmade mock for DB.
        /// This returns a Task because of the await/async semantic.
        /// </summary>
        [TestMethod]
        public async Task HttpRequest_DbThrowsException_Return400()
        {
            // Arrange

            // Mock client. This fn also creates the server
            var client = TestApplicationFactory.BuildFactoryAndClient(new DbMockThatThrowsException());

            // Act
            var response = await client.PostAsJsonAsync(BuildRequestUrl(ValidId), ValidPayload);

            // Assert
            Assert.AreEqual(System.Net.HttpStatusCode.BadRequest, response.StatusCode);
        }

        /// <summary>
        /// Test full Http request to URL endpoint. This versin uses my handmade mock for DB.
        /// This is the version 2 of my test, which uses the Mow library so we don't need to create a custom mock class.
        /// </summary>
        [TestMethod]
        public async Task HttpRequest_DbThrowsException_Return400_v2()
        {
            // Arrange

            // Create a mock for IDb using Moq
            var dbMock = new Moq.Mock<IDb>();
            dbMock.Setup(x => x.UpdateBirth(It.IsAny<int>(), It.IsAny<Person>()))
                .Throws(new Exception($"User with {ValidId} does not exist!"));

            // Mock client. This fn also creates the server
            var client = TestApplicationFactory.BuildFactoryAndClient(dbMock.Object);

            // Act
            var response = await client.PostAsJsonAsync(BuildRequestUrl(ValidId), ValidPayload);

            // Assert
            Assert.AreEqual(System.Net.HttpStatusCode.BadRequest, response.StatusCode);
        }

        /// <summary>
        /// Here we test the direct call to the Post method.
        /// Note how we need to add scaffold code to create the internals of the HttpRequest objects, such as the HttpResponse.
        /// </summary>
        [TestMethod]
        public void MyServlet_DbThrowsException_Return400()
        {
            // Arrange

            // We need to make sure that no exception is thrown
            Exception ex = null!;

            // We also need to mock the HttpCtx, to properly initialize the "Response" object
            var mockCtx = new ControllerContext();
            mockCtx.HttpContext = new DefaultHttpContext();

            // SUT stands for "Service Under Test"
            var sut = new MySvcController(null!, // We don't use logger in this test
                                           new DbMockThatThrowsException(), // Use my mock for IDb
                                           _mapper // We are not mocking mapper, here
                                           );
            sut.ControllerContext = mockCtx;

            // Act
            try
            {
                sut.Post(ValidId, ValidPayload);
            }
            catch (Exception e)
            {
                ex = e;
            }

            // Assert
            Assert.IsNull(ex);
            Assert.AreEqual(mockCtx.HttpContext.Response.StatusCode, 400);
        }
    }
}
