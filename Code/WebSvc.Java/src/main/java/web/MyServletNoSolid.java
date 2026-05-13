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

import thirdparty.MongoDb;

/**
 * Basic servlet
 */
@WebServlet("/MyServletNoSolid")
public class MyServletNoSolid extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private MongoDb _myDb = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletNoSolid() {
        this._myDb = new MongoDb();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * https://something/Myservlet?id=12345&age=34
		 */
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		try {
			this._myDb.externalUpdateBirth(id, age);
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
		
		/*
		 * https://something/Myservlet?id=12345
		 */
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
		
		/**
		 * {
		 *   "age" : 34
		 * }
		 */

		String ageStr = jsonObject.getString("age");
		int age = Integer.parseInt(ageStr);
		// Business logic: check if age format is legal (e.g., >0), etc
		try {
			this._myDb.externalUpdateBirth(id, age);
		}
		catch (Exception e) {
			response.setStatus(400);
		}
	}

}
