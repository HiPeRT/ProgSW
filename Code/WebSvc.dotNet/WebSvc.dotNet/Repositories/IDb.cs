using Model;

namespace Repositories
{
    public interface IDb
    {
        void UpdateBirth(int key, Person p);
    }
}
