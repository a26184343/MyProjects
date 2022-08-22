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
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//delete all session attribute
		session.removeAttribute("id");
		session.removeAttribute("accountNumber");
		session.removeAttribute("depositMessage");
		session.removeAttribute("balance");
		session.removeAttribute("transferMessage");
		session.removeAttribute("deteils");
		session.invalidate();
		response.sendRedirect("Login_or_SignUp.jsp");
	}

}
