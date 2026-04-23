package singleton;

public class MainClass {

	public static void main(String[] args) {
		SingletonClass obj0 = SingletonClass.getInstance();
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		SingletonClass obj3 = SingletonClass.getInstance();
		SingletonClass obj4 = SingletonClass.getInstance();

		obj0.printValAndInc(); // This should print 'Val is 0'
		obj1.printValAndInc(); // This should print 'Val is 1'
		obj2.printValAndInc(); // This should print 'Val is 2'
		obj3.printValAndInc(); // This should print 'Val is 3'
		obj4.printValAndInc(); // This should print 'Val is 4'
	}
}
