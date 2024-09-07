package com.EventManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isExsist;
		isExsist = EventManagementDBUtil.exsistUser(userName);
		
		if (isExsist == true) {
			boolean isTrue;
			isTrue = EventManagementDBUtil.validate(userName, password);
			
			if (isTrue == true) {
				 HttpSession session = request.getSession();
		            session.setAttribute("username", userName);
		            response.sendRedirect("home.jsp");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Your username or password is incorrect');");
				out.println("location='login.jsp'");
				out.println("</script>");
			}
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('User does not exist');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
		
		
	}

}
