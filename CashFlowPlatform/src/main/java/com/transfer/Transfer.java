// 508170222 Nick Chen, 508170301 Matt Hsiao
package com.transfer;

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
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		String counterSide = request.getParameter("counterSide");
		String amount = request.getParameter("amount");
		TransferDao dao = new TransferDao();
		if(dao.checkCounterSideValid(counterSide) && dao.balanceIsEnough(id, amount)) {
			LoginDao loginDao = new LoginDao();
			ProfileDao profileDao = new ProfileDao();
			dao.dealTransfer(loginDao.getAccountNumber(id), counterSide, profileDao.getBalance(loginDao.getAccountNumber(id)), profileDao.getBalance(counterSide), amount);
			session.setAttribute("transferMessage", "Transfer Success!");
			session.removeAttribute("depositMessage");
		} else {
			session.setAttribute("transferMessage", "The counterside status might be wrong, or your balance isn't enough, please check them again.");
		}	
		response.sendRedirect("MainPage.jsp");
	}

}
