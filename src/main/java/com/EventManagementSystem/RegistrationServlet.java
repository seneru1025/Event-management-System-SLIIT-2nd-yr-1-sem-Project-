package com.EventManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean isExsist;

		isExsist = EventManagementDBUtil.exsistUser(username);

		if(isExsist == false) {
	
			boolean isTrue;
			isTrue = EventManagementDBUtil.insertUser(firstName,lastName, phone, email, address, username, password);
	
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
				dis.forward(request, response);
			} else {
				RequestDispatcher dis2 = request.getRequestDispatcher("registration.jsp");
				dis2.forward(request, response);
			}
			
	
			} else {
				// user already exist alert
				out.println("<script type='text/javascript'>");
				out.println("alert('User already exsists!');");
				out.println("location='login.jsp'");
				out.println("</script>");
			}
        
	}

}
