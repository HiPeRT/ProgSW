package unitTests;

import java.io.IOException;
import javax.servlet.ServletException;

import web.MyServlet;

public class MyServletTest {
	
	private static <T>void Assert(T expected, T actual) {
		if(expected != actual) {
			System.out.println("Assertion failed! Expected " + expected + ", got "+ actual + " instead");
			System.exit(-1);
		}
	}

	private static void MyServlet_DbThrowsException_Return400() {
		
		// Arrange
		
		// Mock svcbuilder
		ServicesBuilderForMocks svcBuilder = new ServicesBuilderForMocks();
		
		// Mock up HttpServletRequest and HttpServletResponse
		MyHttpServletRequest request = new MyHttpServletRequest();
	    request.setParameter("id", "1"); // This causes an exception
	    request.setParameter("age", "34");
	    MyHttpServletResponse response = new MyHttpServletResponse();

	    // SUT stands for "Service Under Test"
		MyServlet sut = new MyServlet(svcBuilder);
		
		
		// Act
		
		Exception ex = null;
		
		try {
			sut.doGet(request, response);
		} catch (ServletException e) {
			ex = e;
		} catch (IOException e) {
			ex = e;
		}
		
		// Assert
		
		Assert(ex, null);
		Assert(response.getStatus(), 400);		
	}
	
	public static void main(String[] args) {
		MyServlet_DbThrowsException_Return400();
	}

}
