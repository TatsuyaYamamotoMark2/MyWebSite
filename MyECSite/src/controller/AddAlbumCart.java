package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.MusicBeans;
import beans.UserBeans;
import dao.MusicDAO;

/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/AddAlbum")
public class AddAlbumCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			MusicDAO mdao = new MusicDAO();
			List<MusicBeans> addAlbumCart = mdao.findByalbum_id(request.getParameter("al_id"));

			for (MusicBeans music :addAlbumCart) {
				CartBeans addcart = mdao.findByIdtoCart(music.getM_id());

				if(cart == null) {
					cart = new ArrayList<CartBeans>();
				}
					//カートに商品を追加。
					cart.add(addcart);
					session.setAttribute("cart", cart);
			}
			response.sendRedirect("Album_detail?al_id=" + request.getParameter("al_id") + "&addFlg=2");
		}
	}
}
