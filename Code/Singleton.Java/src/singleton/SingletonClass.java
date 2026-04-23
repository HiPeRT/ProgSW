package singleton;

/**
 * This class implements a Singleton pattern.
 * This class is not thread safe
 */
public class SingletonClass {
	// Used to check whether we are accessing the singleton object
	private int _val = 0;
	
	private static SingletonClass _Instance = null;
	
	private SingletonClass() {
		
	}
	
	public void printValAndInc() {
		System.out.println("Val is " + _val);
		_val++;
	}
	
	public static SingletonClass getInstance() {
		if(_Instance == null)
			_Instance = new SingletonClass();
			
		return _Instance;
	}
}
