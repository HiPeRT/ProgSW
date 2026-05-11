package web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import models.Person;
import services.IPersonaService;
import utils.Mapper;
import utils.WebUtils;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPersonaService _personaSvc = null;
	
    /**
     * We receive it by middleware.
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
