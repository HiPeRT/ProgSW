namespace Services
{
    public class TheEnvironment : IEnvironment
    {
        public bool IsLocal()
        {
            // TODO Read this by configuration file...
            return true;
        }
    }
}
