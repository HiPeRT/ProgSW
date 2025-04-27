package unitTests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.MyServlet;

public class MyServletTest {

	private static void MyServlet_DbThrowsException_Return400() {
		
		// Arrange
		ServicesBuilderForMocks svcBuilder = new ServicesBuilderForMocks();
		MyServlet sut = new MyServlet(svcBuilder);
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		Exception ex = null;
		
		// Act
		try {
			sut.doGet(request, response);
		} catch (ServletException e) {
			ex = e;
		} catch (IOException e) {
			ex = e;
		}
		
		// Assert
		// ex == null;
		// response has return code 400
		
	}
	
	public static void main(String[] args) {
		MyServlet_DbThrowsException_Return400();
	}

}
