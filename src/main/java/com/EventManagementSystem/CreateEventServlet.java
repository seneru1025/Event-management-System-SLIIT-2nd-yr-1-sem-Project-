package com.EventManagementSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Retrieve event details from the form
        String eventName = request.getParameter("eventName");
        String eventType = request.getParameter("eventType");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String expectLocation = request.getParameter("expectLocation");
        int numAttendees = Integer.parseInt(request.getParameter("numAttendees"));
        String eventDescription = request.getParameter("eventDescription");
        boolean foodBeverages = request.getParameter("foodBeverages") != null; // Checkbox
        boolean audioVisual = request.getParameter("audioVisual") != null; // Checkbox
        boolean accommodation = request.getParameter("accommodation") != null; // Checkbox
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        // Get the username from the session
        String username = (String) request.getSession().getAttribute("username");


        // Insert the event into the database (you need to implement this part)
        boolean eventCreated = EventManagementDBUtil.insertEvent(eventName, eventType, eventDate, eventTime, expectLocation, numAttendees, eventDescription, foodBeverages, audioVisual, accommodation, phone, email, username);

        if (eventCreated) {
            response.sendRedirect("EventsServlet"); // Redirect to the events page
        } else {
            // Handle event creation failure (e.g., display an error message)
            response.sendRedirect("create_event.jsp?error=1");
        }
	}

}
