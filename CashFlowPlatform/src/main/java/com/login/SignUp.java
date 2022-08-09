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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		SignUpDao dao = new SignUpDao();
		LoginDao loginDao = new LoginDao();
		if(dao.checkNotDuplicate(id, password) && dao.signUp(id, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("accountNumber", loginDao.getAccountNumber(id));
			response.sendRedirect("MainPage.jsp");
		} else {
			response.sendRedirect("Login_or_SignUp.jsp");
		}
	}

}
