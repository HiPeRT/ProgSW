using Model;
using Repositories;

namespace Services
{
    public class PersonaService : IPersonaService
    {
        private readonly IDb _db;

        public PersonaService(IDb db)
        {
            _db = db;
        }

        public void UpdateBirth(Person p)
            => _db.UpdateBirth(p);

    }
}
