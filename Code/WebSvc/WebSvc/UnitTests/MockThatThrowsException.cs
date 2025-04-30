using Repositories;

namespace UnitTests
{
    public class MockThatThrowsException : IDb
    {
        public void UpdateBirth(int key, int age)
        {
            throw new Exception("User with " + key + " does not exist!");
        }
    }
}
