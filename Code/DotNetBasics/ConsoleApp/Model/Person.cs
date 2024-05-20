namespace DotNetBasics.ConsoleApp.Model
{
    // We can declare this class as "internal" because we don't reference it
    // in any other project

    /// <summary>
    /// This class models a "person", a customer of our gym club.
    /// The preferred choice is *not* to overload constructors to populate fieldsm
    /// but to use Properties directly
    /// </summary>
    internal class Person
    {
        private int _age;

        /// <summary>
        /// Default ctor. I could also remove this
        /// </summary>
        //public Person()
        //{
        //    _age = 0;
        //}

        // 1. Getters and setters ("traditional", Java style)
        //public void SetAge(int age)
        //{
        //    _age = age;
        //}

        //public int GetAge()
        //{
        //    return _age;
        //}

        // 2. Use expression bodies
        public void SetAge(int age) => _age = age;
        public int GetAge() => _age;

        // 3. Use properties
        //public int Age
        //{
        //    get
        //    {
        //        return _age;
        //    }

        //    set
        //    {
        //        // "Guards" make your code more readable
        //        if (value < 0) return;

        //        _age = value;
        //    }
        //}

        // 4. Use body expression for properties
        //public int Age
        //{
        //    get => _age;

        //    set
        //    {
        //        // "Guards" make your code more readable
        //        if (value < 0) return;

        //        _age = value;
        //    }
        //}

        // 5. (if we don't need to add the logic) use expression bodies
        // for the *full* property
        //public int Age => _age;

        // 6. We don't actually need the _age field!
        public int Age { get; internal set; } = 11; // 11 is the default value
    }
}
