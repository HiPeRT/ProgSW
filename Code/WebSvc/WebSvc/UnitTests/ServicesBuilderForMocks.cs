using Repositories;
using Services;

namespace UnitTests
{
    public class ServicesBuilderForMocks : ISvcBuilder
    {
        public IDb CreateDb()
        {
            return new MockThatThrowsException();
        }
    }
}
