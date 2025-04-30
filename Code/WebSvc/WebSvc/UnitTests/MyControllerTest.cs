using Controllers;

namespace UnitTests
{
    public class MyControllerTest
    {
        private static void Assert<T>(T expected, T actual) where T: class
        {
            if (expected != actual)
            {
                Console.WriteLine("Assertion failed! Expected " + expected + ", got " + actual + " instead");
                Environment.Exit(-1);
            }
        }

        private static void MyServlet_DbThrowsException_Return400()
        {
            // Arrange

            // Mock svcbuilder
            //ServicesBuilderForMocks svcBuilder = new ServicesBuilderForMocks();

            // Mock up HttpServletRequest and HttpServletResponse
            //MyHttpServletRequest request = new MyHttpServletRequest();
            //request.setParameter("id", "1"); // This causes an exception
            //request.setParameter("age", "34");
            //MyHttpServletResponse response = new MyHttpServletResponse();

            // SUT stands for "Service Under Test"
            //MySvcController sut = new MySvcController(svcBuilder);

            // Act

            Exception ex = null;

            try
            {
                //sut.Post(request, response);
            }
            catch (Exception e)
            {
                ex = e;
            }

            // Assert

            Assert(ex, null);
            //Assert(response.getStatus(), 400);
        }

        //public static void Main(string[] args)
        //{
        //    MyServlet_DbThrowsException_Return400();
        //}
    }
}
