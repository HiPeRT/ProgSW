using Microsoft.AspNetCore.Mvc.Testing;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.DependencyInjection.Extensions;
using Microsoft.Extensions.Hosting;
using Repositories;
using WebSvc.dotNet;

namespace Tests.Factories
{
    /// <summary>
    /// This class supports the creation of the testing environment
    /// </summary>
    internal class TestApplicationFactory : WebApplicationFactory<Program>
    {
        private readonly IDb _theDb;

        public TestApplicationFactory(IDb theDb)
        {
            _theDb = theDb;
        }

        /// <summary>
        /// Creates the webapplication, and the client
        /// </summary>
        /// <param name="userRepository"></param>
        /// <returns></returns>
        public static HttpClient BuildFactoryAndClient(IDb userRepository)
        {
            var client = new TestApplicationFactory(userRepository)
                .CreateClient(new WebApplicationFactoryClientOptions()
                {
                    BaseAddress = new Uri("https://localhost")
                });

            return client;
        }

        /// <summary>
        /// Overrided method that creates our host
        /// </summary>
        /// <param name="builder"></param>
        /// <returns></returns>
        protected override IHost CreateHost(IHostBuilder builder)
        {
            builder.ConfigureServices(services =>
            {
                _ = services.BuildServiceProvider();
                // Inject the IDb
                services.Replace(new ServiceDescriptor(typeof(IDb), _theDb));
            });

            return base.CreateHost(builder);
        }
    }
}
