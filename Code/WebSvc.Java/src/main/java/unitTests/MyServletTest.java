package unitTests;

import java.io.IOException;
import javax.servlet.ServletException;

import web.MyServlet;

/**
 * Unit and integration tests
 */
public class MyServletTest {
	
	private static void AssertEquals(int expected, int actual) {
		if(expected != actual) {
			System.out.println("Assertion failed! Expected \'" + expected + "\', got \'"+ actual + "\' instead");
			System.exit(-1);
		}
	}
	
	private static void AssertNull(Object o) {
		if(o != null) {
			System.out.println("Assertion failed! object is not null");
			System.exit(-1);
		}
	}

	private static void MyServlet_DbThrowsException_Return400() {
		
		// Arrange
		
		// Mock svcbuilder
		ServicesBuilderForMocks svcBuilder = new ServicesBuilderForMocks();
		
		// Mock up HttpServletRequest and HttpServletResponse
		MyHttpServletRequest request = new MyHttpServletRequest();
	    request.setParameter("id", "11");
	    request.setBody("{\"age\" : \"43\"}");
	    MyHttpServletResponse response = new MyHttpServletResponse();

	    // SUT stands for "Service Under Test"
		MyServlet sut = new MyServlet(svcBuilder.createPersonaService());
		
		
		// Act
		
		Exception ioException = null;
		
		try {
			sut.doPost(request, response);
		} catch (IOException e) {
			ioException = e;
		}
		
		// Assert
		
		AssertNull(ioException); // Check we dit not capture a wrong type of Exception
		AssertEquals(response.getStatus(), 400);
		
		System.out.println("Test successful!");
	}
	
	public static void main(String[] args) {
		MyServlet_DbThrowsException_Return400();
	}

}
