using Model;

namespace Repositories
{
    public class InMemoryDb : IDb
    {
        public IDictionary<int, int> _db = new Dictionary<int, int>();

        public InMemoryDb()
        {
            _db.Add(11, 25);
        }

        public void UpdateBirth(Person p)
        {
            if (!_db.ContainsKey(p.Id))
                throw new Exception($"User with {p.Id} does not exist!");

            _db[p.Id] = p.Age;
        }
    }
}
