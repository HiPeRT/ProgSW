package web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

// We don't want this dependency!!
import repositories.MongoDb;


public class MyServletNoSolid extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private MongoDb _myDb = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletNoClean() {
        this._myDb = new MongoDb()
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			this._myDb.externalUpdateBirth(id, age);
		}
		catch (Exception e) {
			response.setStatus(400);
		}
	}

}
