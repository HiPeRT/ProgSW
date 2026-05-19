using Model;
using ThirdPartyCode;

namespace Repositories
{
    /// <summary>
    /// Adapter pattern to wrap 3rd party MongoDb
    /// </summary>
    public class MongoAdapter : IDb
    {
        private readonly MongoDb _db = new MongoDb();

        public void UpdateBirth(Person p)
            => _db.externalUpdateBirth(p.Id, p.Age);
    }
}
