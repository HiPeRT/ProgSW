package it.unimore.progsw.factory.services;

/**
 * Interface for my DB, with business functionalities
 */
public interface IDb {
	
	public void updateBirth(int key, int age);
	public int getAge(int key);

}
