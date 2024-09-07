package com.EventManagementSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Retrieve event ID from the request (you'll need to pass the event ID as a parameter)
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        
        // Use your EventDBUtil to retrieve event details by ID
        Event event = EventManagementDBUtil.getEventById(eventId);

        // Set the event as an attribute in the request
        request.setAttribute("event", event);

        // Forward to the eventDetails.jsp for displaying event details and options
        request.getRequestDispatcher("editEvent.jsp").forward(request, response);
	}

}
