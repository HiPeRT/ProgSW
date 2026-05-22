public class MainClass {
	
	public static void main(String[] args) {
		
		// To have a lambda work properly in java you need to create an interface or a class
		// to provide an abstraction to invoke some code
		ILambda myLambda = (a) -> {
		    System.out.println("Lambda called with " + a);
		};
	
		// Call it directly...
		myLambda.run(4);
		
		// ..or combine it with a Visitor pattern.
		MyLambdaInvoker myvisitor = new MyLambdaInvoker(6);
		myvisitor.invoke(myLambda);
	
		// You can also use an inline lambda
		myvisitor.invoke(
		    (a) -> System.out.println("Lambda called with " + a)
		    );
		
		}
}
