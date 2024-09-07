package com.EventManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the user's session to retrieve the username
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username != null) {
            // Retrieve user data from the database based on the username
        	List<User> user = EventManagementDBUtil.getUser(username);

            if (user != null) {
                // Set the user data as an attribute in the request
                request.setAttribute("user", user);

                // Forward the request to the profile.jsp page for displaying the user's profile
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                // Handle the case where the user is not found in the database
                response.sendRedirect("error.jsp"); // You can create an error page for this
            }
        } else {
            // Handle the case where the user is not logged in (no username in the session)
            response.sendRedirect("login.jsp"); // Redirect to the login page
        }
        
	}


}
