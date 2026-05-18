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
        public string Payload { get; set; }

        //public int Id
        //{
        //    get
        //    {
        //        return _id;
        //    }
        //    set
        //    {
        //        _id = value;
        //    }
        //}

        public int Id
        {
            get => _id;
            set => _id = value;
        }


        public int Return2() { get;} => 2;
    }
}
