package person;

/**
 * This class uses fluent initialization
 */
public class PersonFluent {
	
	private String _name = null;
	
	private Boolean _immutable = false;
	private PersonCfg _cfg = null;
	
	private PersonStatus _status = PersonStatus.UNKNOWN;
	
	public PersonFluent() {
		this._cfg = new PersonCfg();
		this._status = PersonStatus.NEW;
	}
	
	/**
	 * To hide away the two different implementations
	 * @return
	 */
	private Boolean isImmutable() {
		return this._cfg.Immutable;
	}
	
	/**
	 * Clone this, if we are immutable.
	 * Note: there are better ways to do this..
	 * @return
	 */
	private PersonFluent cloneThis() {
		PersonFluent p = new PersonFluent();
		p._name = this._name;
		p._status = this._status;
		p._cfg = this._cfg;
		// ...other fields
		return p;
	}
	
	/*
	 * Check for the consistency
	 */
	private void throwIfStatusIsNot(PersonStatus wanted) throws Exception {
		if(this._status != wanted)
			throw new Exception("Operation permitted only in status "
				+ wanted + ". Found " + this._status);
	}
	
	/**
	 * Version with params. Each time you have a new configuration option
	 * you need to add a param to this fn.
	 * This must be the first method that you call on your chain.
	 * @param immutable
	 * @return
	 * @throws Exception
	 */
	public PersonFluent Config(Boolean immutable) throws Exception {
		throwIfStatusIsNot(PersonStatus.NEW);
		
		this._immutable = immutable;
		
		this._status = PersonStatus.INITING;
		
		
		return isImmutable() ? cloneThis() : this;
	}
	
	/**
	 * Version with Cfg obj. This is more scalable.
	 * This must be the first method that you call on your chain.
	 * @param lambda
	 * @return
	 * @throws Exception
	 */
	public PersonFluent Config(ILambdaWithTemplate<PersonCfg> lambda) throws Exception {
		throwIfStatusIsNot(PersonStatus.NEW);
		
		// Let the lambda visit my config object
		lambda.run(this._cfg);
		
		this._status = PersonStatus.INITING;
		
		return isImmutable() ? cloneThis() : this;
	}
	
	/**
	 * Set Name (fluent)
	 */
	public PersonFluent withName(String name) throws Exception {
		throwIfStatusIsNot(PersonStatus.INITING);
		
		this._name = name;
		
		this._status = PersonStatus.INITING;
		
		return isImmutable() ? cloneThis() : this;
	}
	
	/**
	 * This must be the last method that you call on your chain.
	 * @return
	 * @throws Exception
	 */
	public PersonFluent Persist() throws Exception {
		throwIfStatusIsNot(PersonStatus.INITING);
		
		// Do something.

		this._status = PersonStatus.READY;
		
		return isImmutable() ? cloneThis() : this;
	}
	
	@Override
	public String toString() {
		
		return "Name: " + this._name;
	}

}
