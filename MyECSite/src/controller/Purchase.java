package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.UserBeans;
import dao.Buy_detailDAO;
import dao.Buy_historyDAO;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {

			//ログインユーザー取得
			UserBeans loginUser = (UserBeans) session.getAttribute("usb");
			//カート取得
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");


			//購入履歴登録
			Buy_historyDAO BHD = new Buy_historyDAO();
			String resultHistroyID = String.valueOf(BHD.addHistory(loginUser.getId()));

			//購入詳細登録
			boolean resultAddBuy = false;
			for(CartBeans cartMusic : cart) {
			Buy_detailDAO BDD = new Buy_detailDAO();
			resultAddBuy =  BDD.addDetail(resultHistroyID,cartMusic.getM_id());
			}
			//カートをクリア
			request.getSession().removeAttribute("cart");

			if(resultAddBuy) {//処理成功
				String resultMessage = "購入完了";
				String buttonValue = "MY LIBRARY";
				String link = "Library?id="+loginUser.getId();
				request.setAttribute("resultMessage", resultMessage);
				request.setAttribute("buttonValue", buttonValue);
				request.setAttribute("link", link);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);

			}else{//エラー
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
