
namespace DotNetBasics.MySharedProject
{
    /// <summary>
    /// This class is divided into two separate file
    /// <see also cref="MyClass"/>
    /// </summary>
    public partial class MyClass
    {
        private static MyClass? _instance;
        private MyClass()
        {
            
        }

        public static MyClass GetInstance()
        {
            if(_instance == null)
                _instance = new MyClass();
            return _instance;
        }

        public static MyClass? MaybeReturnObject(int a)
        {
            if(a == 0) return null;

            return GetInstance();
        }

        public int MultiplyByTwo(int x)
        {
            return x * 2;
        }
    }
}
