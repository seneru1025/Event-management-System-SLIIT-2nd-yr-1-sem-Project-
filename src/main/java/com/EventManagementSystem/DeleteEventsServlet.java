package com.EventManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteEventsServlet")
public class DeleteEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve event ID from the request (you'll need to pass the event ID as a parameter)
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        
        boolean isTrue;
        
        isTrue = EventManagementDBUtil.deleteEvent(eventId);
		
        if (isTrue == true) {
        	response.sendRedirect("EventsServlet");
		}
		else {
			
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('Delete account failed!');");
			out.println("location='userProfile.jsp'");
			out.println("</script>");
			

		}
	}

}
