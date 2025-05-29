using Model;
using Repositories;

namespace Tests.Mocks
{
    internal class DbMockThatThrowsException : IDb
    {
        public void UpdateBirth(int key, Person p)
        {
            throw new Exception("User with " + key + " does not exist!");
        }
    }
}
