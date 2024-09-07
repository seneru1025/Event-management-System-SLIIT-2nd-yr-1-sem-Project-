package com.EventManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EventsServlet")
public class EventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the username from the session
        String username = (String) request.getSession().getAttribute("username");
        
        // Use your EventDBUtil to retrieve a list of events for this username
        List<Event> events = EventManagementDBUtil.getEventsForUser(username);
        
        // Set the list of events as an attribute in the request
        request.setAttribute("events", events);
        
        // Forward to the events.jsp page for displaying the events
        request.getRequestDispatcher("events.jsp").forward(request, response);
	}



}
