package com.EventManagementSystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the user's session to retrieve the username
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		boolean isTrue;
		
		isTrue = EventManagementDBUtil.updateUser(firstname, lastname, email, phone, address, username);
		
		if(isTrue == true) {
			
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
		}
		else {
			
			 response.sendRedirect("login.jsp"); // Redirect to the login page
		}
	}

}
