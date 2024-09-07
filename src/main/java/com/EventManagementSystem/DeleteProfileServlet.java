package com.EventManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Get the user's session to retrieve the username
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        boolean isTrue;
        
        isTrue = EventManagementDBUtil.deleteUser(username);
		
        if (isTrue == true) {
        	 response.sendRedirect("login.jsp"); // Redirect to the login page
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
