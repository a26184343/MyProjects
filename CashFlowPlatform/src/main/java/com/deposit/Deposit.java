// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.deposit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.LoginDao;
import com.upload.ProfileDao;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		String amount = request.getParameter("depositAmount");
		//remove transfer message
		session.removeAttribute("message");
		ProfileDao dao = new ProfileDao();
		//upload balance
		LoginDao loginDao = new LoginDao();
		DepositDao depositDao = new DepositDao();
		depositDao.deposit(loginDao.getAccountNumber(id), amount);
		session.setAttribute("depositMessage", "Deposit Success!");
		session.removeAttribute("transferMessage");
		response.sendRedirect("MainPage.jsp");
	}

}
