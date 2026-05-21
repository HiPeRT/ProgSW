namespace ConsoleApp.ADStack
{
    [Serializable]
    internal class IncoherentStackException : Exception
    {
        public IncoherentStackException()
        {
        }

        public IncoherentStackException(string? message) : base(message)
        {
        }
    }
}