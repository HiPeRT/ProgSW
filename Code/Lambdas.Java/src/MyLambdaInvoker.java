/**
 * This class invokes a lambda expression, and the int value is increased at every invocation.
 */
public class MyLambdaInvoker {
	private int _a;

	public MyLambdaInvoker(int a) {
	    this._a = a;
	}

	public void invoke(ILambda action) {
		// Let's assume that for some business logics, a shall be incremented at every invocation.
	    action.run(_a++);
	}   
}
