
public class SingletonClass {
	private static SingletonClass _Instance = null;
	private SingletonClass() {
	}

	public static SingletonClass GetInstance() {
		
		// Lazy loading (another pattern!)
		if(_Instance == null)
			_Instance = new SingletonClass();
		
		return _Instance;
	}
	
	public void foo() {
		System.out.println("Hello World!");
	}
}
