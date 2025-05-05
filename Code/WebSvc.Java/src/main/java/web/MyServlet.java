package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import models.Person;
import services.IPersonaService;
import services.ServiceBuilder;
import utils.Mapper;
import utils.WebUtils;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPersonaService _personaSvc = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        this(ServiceBuilder.GetInstance().createPersonaService());
    }

    /**
     * Explicitly assign svcBuilder. This is used for testing.
     * We'll see how this is handled in Middleware...
     * @param svcBuilder
     */
    public MyServlet(IPersonaService personaSvc) {
        super();
        
        this._personaSvc = personaSvc;
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));

	      
      	JSONObject jsonObject = null;
		try {
		    jsonObject = WebUtils.getHttpRequestBodyAsJson(request);
		  } catch (JSONException e) {
			response.getWriter().append(e.getMessage() + "\n" + e.getStackTrace().toString());
			return;
		  }
		
		Person p = Mapper.mapToPerson(id, jsonObject);		
		
		try {
			this._personaSvc.updateBirth(p);
		}
		catch (Exception e) {
			response.setStatus(400);
		}
	}

}
