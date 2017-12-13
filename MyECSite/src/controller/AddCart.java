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
import dao.MusicDAO;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {
			MusicDAO mdao = new MusicDAO();
			CartBeans addcart = mdao.findByIdtoCart(request.getParameter("m_id"));

			if(addcart != null) {
				//カートを用意
				ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
				//セッションにカートがなければカートを作成
				if (cart == null) {
					cart = new ArrayList<CartBeans>();
				}
				//カートに商品を追加。
				cart.add(addcart);
				String resultMessage = "カートに楽曲を追加しました";
				request.setAttribute("resultMessage", resultMessage);
				request.setAttribute("cart", cart);
				session.setAttribute("cart", cart);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
				dispatcher.forward(request, response);
			}else{

				String errorMessage = "カート追加に失敗しました";
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
