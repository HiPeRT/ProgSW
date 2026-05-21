using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Repository of maps read from file
    /// </summary>
    internal class FileMapRepository
    {
        public FileMapRepository(string filename)
        {
        }

        public IMap Get(string city)
        {
            return new Map();
        }
    }
}