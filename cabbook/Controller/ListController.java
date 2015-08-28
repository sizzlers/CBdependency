package com.verizon.cabbook.Controller;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import utilities.CabLogger;

import com.verizon.cabbook.Services.GetServices;
import com.verizon.cabbook.model.UserBean;


public class ListController extends HttpServlet {
	 private static final long serialVersionUID = 0L;
	 GetServices oService = null;
	 private ServletConfig config;
	 private static Logger logger = CabLogger.getLogger(ListController.class);
	// org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ListController.class.getName()); 
	 
	 public void init(ServletConfig config) throws ServletException {
	        this.config = config;
	        super.init(config);
	    }
	 
	   /**
	     * @param request
	     * @param response
	     * @throws ServletException
	     * @throws IOException
	     */
	    public void doGet(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);

	    }

	    /**
	     * @param request
	     * @param response
	     * @throws ServletException
	     * @throws IOException
	     */
	    
	  public void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
 try {
	 logger.info("Inside servlet");
     String type = request.getParameter("type");
     
     if ("getData".equalsIgnoreCase(type)) {
         //doViewDocumentDetails(request, response);
        
    	 getMassMetadata(request, response); //August 8th Release QC:2288
     }
     else if ("getUserDetails".equalsIgnoreCase(type)) {
                
    	 getUserDetails(request, response); //August 8th Release QC:2288
     }      
     else if ("submitTrip".equalsIgnoreCase(type)) {
         //doViewDocumentDetails(request, response);
         System.out.println("Hi changed");
    	 logger.info("Inside get Metadata");
    	 submitTripRequest(request, response); //August 8th Release QC:2288
     }      
     
     
 } catch(SocketException se){
     //throw se;
 }catch (Exception e) {
     logger.error("Error in servlet::" + e);
 }
}  
	 private void getMassMetadata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {

		oService = new GetServices();
		String metaVal="";
		HashMap<String,String> mapMetadata = new HashMap<String,String>();
		
		mapMetadata = oService.getMassMetadata();
	
		request.setAttribute("mapMetaData", mapMetadata);          
		request.setAttribute("testjstl", "Hello JSTL");
		request.getRequestDispatcher("/jsp/display.jsp").include(request,response);
	} catch (Exception e) {

	request.setAttribute("expcatch", e);
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/errorPage.jsp");
	rd.include(request, response);
	}
	}

	 private void getUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {

		oService = new GetServices();
		
		UserBean oUserBean = new UserBean();
		String vzId="907066";
		if(request.getParameter("username")!=null)
			vzId = request.getParameter("username");
		
		oUserBean = oService.getUserDetails(vzId);
	
		request.getSession().setAttribute("UserDetails", oUserBean);          
		
		request.getRequestDispatcher("/jsp/cabbook.jsp").include(request,response);
	} catch (Exception e) {

	request.setAttribute("expcatch", e);
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/errorPage.jsp");
	rd.include(request, response);
	}
	}

	 private void submitTripRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {

				oService = new GetServices();
				
				UserBean oUserBean = new UserBean();
				int userID=0;
				if(request.getParameter("hdnUserId")!=null)
					userID = Integer.parseInt(request.getParameter("hdnUserId"));
				
				boolean isSucc = oService.submitTrip(userID);
				
				request.setAttribute("succMsg","Submitted Sucessfully.You will be notified soon!!");
				request.getRequestDispatcher("/jsp/cabbook.jsp").include(request,response);
				
			} catch (Exception e) {

			request.setAttribute("expcatch", e);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/errorPage.jsp");
			rd.include(request, response);
			}
			}

}
