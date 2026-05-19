using Model;

namespace Services
{
    public interface IPersonaService
    {
        /// <summary>
        /// Update age of a person in DB
        /// </summary>
        /// <param name="p"></param>
        void UpdateBirth(Person p);
    }
}
