using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    internal class MyDataType
    {
        private int _id;
        private string _payload = "";

        //public void SetId(int id)
        //{
        //    _id = id;
        //}

        //public int GetId()
        //{
        //    return _id;
        //}

        // Property that shadows the _id field
        public int Id
        {
            get
            {
                return _id;
            }
            set
            {
                _id = value;
            }
        }

        // Properties with body expression
        //public string Payload => _payload;
        public string Payload
        {
            get
            {
                return _payload;
            }
            set
            {
                _payload = value;
            }
        }

        // Function with body expression
        public int MultiplydByFour() => _id * 4;
    }
}
