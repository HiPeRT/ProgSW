using Microsoft.VisualStudio.TestTools.UnitTesting;
using MyClassLibrary;
using System;

namespace UnitTests
{
    /// <summary>
    /// Unit tests for MyClassLibrary
    /// </summary>
    [TestClass]
    public class MyClassLibraryUnitTest
    {
        [TestMethod]
        public void DivideByTwo_NegativeInput_ThrowsException()
        {
            // Arrange
            MyClass sut = new MyClass();
            Exception ex = null;

            // Act
            try
            {
                sut.DivideByTwo(-1);
            }
            catch (ArgumentException e)
            {
                ex = e;
            }

            // Assert
            Assert.IsNotNull(ex);
            Assert.IsInstanceOfType(ex, typeof(ArgumentException));
        }

        /// <summary>
        /// Second version of the same test as before, which uses Attributes to specify the expected result
        /// </summary>
        [TestMethod]
        [ExpectedException(typeof(ArgumentException), "An ArgumentException was expected")]
        public void DivideByTwo_NegativeInput_ThrowsException_2()
        {
            // Arrange
            MyClass sut = new MyClass();

            // Act
            sut.DivideByTwo(-1);

            // Assert
            //  Really nothing to do, here...
        }

        /// <summary>
        /// Correct functionality (even nr).
        /// </summary>
        [TestMethod]
        public void DivideByTwo_PositiveInput_CorrectResult()
        {
            // Arrange
            MyClass sut = new MyClass();
            int testVal = 14;

            // Act
            var retval = sut.DivideByTwo(testVal);


            // Assert
            Assert.AreEqual(testVal / 2, retval);
        }
    }
}
