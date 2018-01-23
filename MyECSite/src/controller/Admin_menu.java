package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.UtillLogic;
import beans.AlbumBeans;
import beans.ArtistBeans;
import beans.UserBeans;
import dao.AlbumDAO;
import dao.ArtistDAO;

/**
 * Servlet implementation class Admin_menu
 */
@WebServlet("/Admin_menu")
public class Admin_menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBeans user = (UserBeans) session.getAttribute("usb");
		int loginuserID = Integer.parseInt(user.getId());
		int i = 1;
		if (loginuserID == i) {
			AlbumDAO al_DAO = new AlbumDAO();
			List<AlbumBeans> albumList = al_DAO.findAll();
			ArtistDAO ar_DAO = new ArtistDAO();
			List<ArtistBeans> artistList = ar_DAO.findAll();
			request.setAttribute("albumList", albumList);
			request.setAttribute("artistList", artistList);

			UtillLogic.redirectResultMessage(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_menu.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errorMessage", "不正なアクセス");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		}
	}
}