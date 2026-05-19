using Model;

namespace Repositories
{
    /// <summary>
    /// Interface to persistence layer
    /// </summary>
    public interface IDb
    {
        /// <summary>
        ///  Update birth date of a person in DB
        /// </summary>
        /// <param name="p"></param>
        void UpdateBirth(Person p);
    }
}
