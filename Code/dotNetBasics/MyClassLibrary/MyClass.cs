using System;

namespace MyClassLibrary
{
    /// <summary>
    /// /This class implements the business functionality
    /// </summary>
    public class MyClass
    {
        /// <summary>
        ///  Divide an integer by two. If the number is negative or equal to zero,
        ///  throw an <see cref="System.ArgumentException"/>
        /// </summary>
        /// <param name="a"></param>
        /// <returns></returns>
        public int DivideByTwo(int a)
        {
            if (a <= 0) throw new ArgumentException($"Inut number cannot be <=0, i.e., {a}");
            return a / 2;
        }
    }
}
