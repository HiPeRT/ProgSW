package diwithguice;

/**
 * This is the interface to the service we want to inject
 */
public class MyWriter implements IWriter {

	@Override
	public void writer(String s) {
		System.out.println("The string is " + s);
	}

}
