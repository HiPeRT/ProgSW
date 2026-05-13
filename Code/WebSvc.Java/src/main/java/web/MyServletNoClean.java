package web;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import repositories.IDb;
import services.ISvcBuilder;

/**
 * SOLID but not clean servlet
 */
@WebServlet("/MyServletNoClean")
public class MyServletNoClean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDb _myDb = null;
       
    /**
     * Explicitly assign svcBuilder in ctor. In a real CLEAN middleware (e.g., Guice) we receive directly the DB as we implement DI.
     * @param svcBuilder
     */
    public MyServletNoClean(ISvcBuilder svcBuilder) {
        super();
        
        this._myDb = svcBuilder.createDb();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		try {
			this._myDb.updateBirth(id, age);
		}
		catch (Exception e) {
			// Return Http code 400
			response.setStatus(401); // This is wrong on purpose!
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

		
		StringBuilder requestBody = new StringBuilder();
	      String line;
	      try (BufferedReader reader = request.getReader()) {
	         while ((line = reader.readLine()) != null) {
	            requestBody.append(line).append("\n");
	         }
	      }
	      
      	JSONObject jsonObject = null;
		try {
		    jsonObject = new JSONObject(requestBody.toString());
		  } catch (JSONException e) {
			response.getWriter().append(e.getMessage() + "\n" + e.getStackTrace().toString());
			return;
		  }

		String ageStr = jsonObject.getString("age");
		int age = Integer.parseInt(ageStr);
		// Business logic: check if age format is legal (e.g., >0), etc
		try {
			this._myDb.updateBirth(id, age);
		}
		catch (Exception e) {
			response.setStatus(400);
		}
	}

}