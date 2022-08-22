// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		LoginDao dao = new LoginDao();
		if(dao.check(id, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("accountNumber", dao.getAccountNumber(id));
			response.sendRedirect("MainPage.jsp");
		} else {
			response.sendRedirect("Login_or_SignUp.jsp");
		}
	}
}
