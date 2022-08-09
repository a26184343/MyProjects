// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deposit.DepositDao;
import com.login.LoginDao;
import com.transfer.TransferDao;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		//remove transfer message
		session.removeAttribute("depositMessage");
		session.removeAttribute("transferMessage");
		ProfileDao dao = new ProfileDao();
		//upload balance
		LoginDao loginDao = new LoginDao();
		session.setAttribute("balance", dao.getBalance(loginDao.getAccountNumber(id)));
		session.setAttribute("details", dao.getDetails(loginDao.getAccountNumber(id)));
		response.sendRedirect("MainPage.jsp");
	}

}
