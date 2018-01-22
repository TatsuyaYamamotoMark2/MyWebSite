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

import base.UtillLogic;
import beans.CartBeans;
import beans.UserBeans;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {

			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			//カートがなければカート作成
			if (cart == null) {
				cart = new ArrayList<CartBeans>();
			}
			//カートが空ならカート削除
			if (cart.size() == 0) {
				request.getSession().removeAttribute("cart");
			}
			int cartPrice = 0;
			for(CartBeans cartitem : cart) {
				cartPrice += Integer.parseInt(cartitem.getM_price());
			}


			request.setAttribute("cartPrice", cartPrice);
			UtillLogic.redirectResultMessage(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
			dispatcher.forward(request, response);
		}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
