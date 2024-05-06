package it.unimore.progsw.factory.testing;

import it.unimore.progsw.factory.services.IEnv;
import it.unimore.progsw.factory.services.ISvcBuilder;
import it.unimore.progsw.factory.services.LocalEnvironment;
import it.unimore.progsw.factory.services.ServicesBuilder;
import it.unimore.progsw.factory.web.WebSvc;

/**
 * Class that performs unit testing.
 * Note: I am not using any testing framework, here (e.g., JUnit),
 * for the sake of code readability
 */
public class UnitTestingMain {

	/*
	 * Same across all tests, we can store it in a local field
	 */
	private static IEnv _environment = null;
	
	/*
	 * Support functions
	 */
	private static void SetupTest() {
		_environment = new LocalEnvironment();
	}
	
	private static void DisposteTests() {
		// Nothing to do...
	}
	
	private static void Assert(Boolean condition) {
		if(!condition) {
			System.out.println("---- TEST FAILED");
			System.exit(0);
		}
	}
	
	private static void TestThatThrowsException() {

		// Arrange
		ISvcBuilder builder = new ServicesBuilderForMocks();
		// "sut" => "System Under Test"
		WebSvc sut = new WebSvc(builder).start();

		Boolean success = false;
		// Act (Invoke the endpoint)
		try 
		{
			sut.Endpoint_UpdateBirth(0, 0);
		
		}
		catch (NullPointerException e) {
			success = true;
			System.out.println("[TestThatThrowsException] success!");
		}
		
		// Assert
		Assert(success);
	}
	

	private static void TestLocalDb() {

		// Arrange
		ISvcBuilder builder = new ServicesBuilder(_environment);		
		WebSvc sut = new WebSvc(builder).start();
		int key = 11;
		int age = 42;
		
		// Act
		sut.Endpoint_UpdateBirth(key, age);
		
		// Assert
		Assert(sut.getDb().getAge(key) == age);
	}

	/**
	 * Entry point for tests. Here, no framework for Unit Test is used.
	 * @param args
	 */
	public static void main(String[] args) {

		// Common setup for tests
		SetupTest();
		
		// Run tests
		TestThatThrowsException();
		
		TestLocalDb();
		
		// Dispose
		DisposteTests();
	}

}
