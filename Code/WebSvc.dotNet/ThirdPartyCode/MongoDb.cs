
namespace ThirdPartyCode
{
    /// <summary>
    /// MongoDb library
    /// </summary>
    public class MongoDb
    {
        public void externalUpdateBirth(int key, int age)
        {
            Console.WriteLine($"Hello, I am an external MongoDb library! I am updating age ({age}) for user with id '{key}'");
        }
    }
}
