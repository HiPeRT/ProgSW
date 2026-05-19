using Model;
using Repositories;

namespace Tests.Mocks
{
    internal class DbMockThatThrowsException : IDb
    {
        public void UpdateBirth(Person p)
        {
            throw new Exception($"User with {p.Id} does not exist!");
        }
    }
}
