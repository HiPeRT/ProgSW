using Repositories;

namespace Services
{
    public interface ISvcBuilder
    {
        IDb CreateDb();
    }
}
