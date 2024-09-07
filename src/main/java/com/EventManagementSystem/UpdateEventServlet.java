package com.EventManagementSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 // Retrieve updated event details from the form
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String eventName = request.getParameter("eventName");
        String eventType = request.getParameter("eventType");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String expectLocation = request.getParameter("expectLocation");
        int numAttendees = Integer.parseInt(request.getParameter("numAttendees"));
        String eventDescription = request.getParameter("eventDescription");
        boolean foodBev = request.getParameter("foodBev") != null;
        boolean audioVisual = request.getParameter("audioVisual") != null;
        boolean accommodation = request.getParameter("accommodation") != null;
        
        
        // Use EventManagementDBUtil to update the event details
        boolean eventUpdated = EventManagementDBUtil.updateEvent(eventId, eventName, eventType, eventDate, eventTime, expectLocation, numAttendees, eventDescription, foodBev, audioVisual, accommodation);

        if (eventUpdated) {
            // Redirect to the event details page
            response.sendRedirect("EventDetailsServlet?eventId=" + eventId);
        } else {
            // Handle event update failure (e.g., display an error message)
            response.sendRedirect("updateEvent.jsp?error=1");
        }
	}

}
