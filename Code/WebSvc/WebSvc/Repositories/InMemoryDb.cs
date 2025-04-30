namespace Repositories
{
    public class InMemoryDb : IDb
    {
        public IDictionary<int, int> _db = new Dictionary<int, int>();

        public InMemoryDb()
        {
            _db.Add(11, 25);
        }

        public void UpdateBirth(int key, int age)
        {
            if (!_db.ContainsKey(key))
                throw new Exception("User with " + key + " does not exist!");

            _db[key] = age;
        }
    }
}
