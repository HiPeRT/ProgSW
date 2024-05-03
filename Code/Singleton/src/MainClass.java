
public class MainClass {
	public static void main(String[] args) {
		SingletonClass obj = SingletonClass.GetInstance();
		obj.foo();
		SingletonClass obj2 = SingletonClass.GetInstance();
		obj2.foo();
		System.out.println(obj.equals(obj2));
	}
}
