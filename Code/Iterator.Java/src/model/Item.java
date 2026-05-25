package model;

/**
 * Business entity. This represent the element we want to store in the data structure.
 */
public class Item {

	private int _payload;

	public int getPayload() {
		return _payload;
	}
	
	public Item(int payload) {
		this._payload = payload;
	}
	
	@Override
	public String toString() {
		return "Element [_payload=" + _payload + "]";
	}

}
