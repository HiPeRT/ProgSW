package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.IDb;
import services.ISvcBuilder;
import services.ServiceBuilder;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDb _myDb = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        this(ServiceBuilder.GetInstance());
    }
    
    /**
     * Explicitly assign svcBuilder. This is used for testing.
     * We'll see how this is handled in Middleware...
     * @param svcBuilder
     */
    public MyServlet(ISvcBuilder svcBuilder) {
        super();
        
        this._myDb = svcBuilder.createDb();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		try {
			this._myDb.updateBirth(id, age);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
