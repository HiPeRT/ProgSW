package models;

/**
 * A Bean that models a User of our system
 */
public class Person {
	
	private int _id;
	private int _age;
	
	public int getId() {
		return _id;
	}
	
	public void setId(int id) {
		this._id = id;
	}
	
	public int getAge() {
		return _age;
	}
	
	public void setAge(int age) {
		this._age = age;
	}
}
