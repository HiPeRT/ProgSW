using System.Net.NetworkInformation;

namespace ConsoleApp.Person
{
    enum PersonStatus
    {
        UNKNOWN = 0, NEW, INITING, READY
    }

    /// <summary>
    /// This class uses fluent initialization.
    /// </summary>
    internal class PersonFluent
    {
        private string _name;

        private bool _immutable;
        private PersonCfg _cfg;

        private PersonStatus _status = PersonStatus.UNKNOWN;

        public PersonFluent()
        {
            _cfg = new PersonCfg();
            _status = PersonStatus.NEW;
            _name = string.Empty;
        }

        /// <summary>
        /// To hide away the two different implementations
        /// </summary>
        /// <returns></returns>
        private bool isImmutable() => _cfg.Immutable;

        /// <summary>
        /// Clone this, if we are immutable.
        /// Note: there are better ways to do this..
        /// </summary>
        /// <returns></returns>
        private PersonFluent CloneThis()
        {
            PersonFluent p = new PersonFluent();
            p._name = this._name;
            p._status = this._status;
            p._cfg = this._cfg;
            // ...other fields
            return p;
        }

        /// <summary>
        /// Check for the consistency
        /// </summary>
        /// <param name="wanted"></param>
        private void ThrowIfStatusIsNot(PersonStatus wanted)
        {
            if (_status != wanted)
                throw new Exception($"Operation permitted only in status {wanted}. Found {_status}");
        }

        /// <summary>
        /// Version with params. Each time you have a new configuration option you need to add a param to this fn.
        /// This must be the first method that you call on your chain.
        /// </summary>
        /// <param name="immutable"></param>
        /// <returns></returns>
        public PersonFluent Config(bool immutable)
        {
            ThrowIfStatusIsNot(PersonStatus.NEW);
		
		    _immutable = immutable;
		
		    _status = PersonStatus.INITING;
		    return isImmutable() ? CloneThis() : this;
        }

        /// <summary>
        /// Version with Cfg obj. This is more scalable.
        /// This must be the first method that you call on your chain.
        /// </summary>
        /// <param name="lambda"></param>
        /// <returns></returns>
        public PersonFluent Config(Action<PersonCfg> lambda)
        {
            ThrowIfStatusIsNot(PersonStatus.NEW);
		
		    // Let the lambda visit my config object
		    lambda(_cfg);
		
		    _status = PersonStatus.INITING;
		
		    return isImmutable()? CloneThis() : this;
        }

        /// <summary>
        /// Set Name (fluent)
        /// </summary>
        /// <param name="name"></param>
        /// <returns></returns>
        public PersonFluent WithName(string name)
        {
            ThrowIfStatusIsNot(PersonStatus.INITING);
		
		    _name = name;
		
		    _status = PersonStatus.INITING;
		
		    return isImmutable() ? CloneThis() : this;
        }

        /// <summary>
        /// This must be the last method that you call on your chain.
        /// </summary>
        /// <returns></returns>
        public PersonFluent Persist()
        {
            ThrowIfStatusIsNot(PersonStatus.INITING);
		
		    // Do something.

		    _status = PersonStatus.READY;
		
		    return isImmutable() ? CloneThis() : this;
        }

        public override string ToString() => $"Name: {_name}";
    }
}
