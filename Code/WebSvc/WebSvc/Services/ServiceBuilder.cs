using Repositories;

namespace Services
{
    public class ServiceBuilder : ISvcBuilder
    {
        private static ServiceBuilder _instance;
        private IEnvironment _env;

        public ServiceBuilder()
        {
            // TODO we will see how this is handled by a MW...
            this._env = new TheEnvironment();
        }

        public static ISvcBuilder GetInstance()
        {
            if (_instance == null)
                _instance = new ServiceBuilder();

            return _instance;
        }

        public IDb CreateDb()
        {
            if (_env.IsLocal())
                return new InMemoryDb();
            return new MongoDB();
        }
    }
}
