namespace Iterator.Model
{
    //Business entity. This represent the element we want to store in the data structure.
    internal class Item
    {
        private int _payload;

        public int Payload
        {
            get { return _payload; }
        }

        public Item(int payload)
        {
            _payload = payload;
        }

        override public string ToString()
        {
            return $"Element payload: {_payload}";
        }
    }
}
