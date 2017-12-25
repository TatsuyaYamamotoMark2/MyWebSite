package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ArtistBeans;
import beans.UserBeans;
import dao.ArtistDAO;
import dao.MusicDAO;

/**
 * Servlet implementation class Update_Artist
 */
@WebServlet("/Update_Artist")
public class Update_Artist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {
			String id = request.getParameter("select");
			String submit = request.getParameter("submit");
			ArtistDAO arDAO = new ArtistDAO();
			MusicDAO mDAO = new MusicDAO();
			RequestDispatcher dispatcher = null;



			switch(submit) {
				case "update":
					ArtistBeans artist = arDAO.findById(id);
					request.setAttribute("artist", artist);
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_artist.jsp");
					break;
				case "delete":
					boolean result = mDAO.findByArtist_id(id);
					if(result) {
						request.setAttribute("errorMessage", "指定のアーティストは楽曲に設定中です");
					}else {
						arDAO.removeById(id);
						request.setAttribute("resultMessage", "アーティストを削除しました");
					}
					dispatcher = request.getRequestDispatcher("Admin_menu");
					break;

				case "new":
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_artist.jsp");
					break;
			}
			dispatcher.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {
			String id = request.getParameter("id");
			String submit = request.getParameter("submit");
			String ar_name = request.getParameter("name");
			ArtistDAO arDAO = new ArtistDAO();

			switch(submit) {
				case "UPDATE":
					boolean resultUpdate = arDAO.updateArtist(ar_name,id);
					response.sendRedirect("Admin_menu?addFlg=7");
					break;
				case "ADD":
				try {
					boolean resultADD = arDAO.addArtist(ar_name);
					response.sendRedirect("Admin_menu?addFlg=8");
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} finally {
					break;
				}
			}
		}
	}
}
