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

import beans.AlbumBeans;
import beans.MusicBeans;
import beans.UserBeans;
import dao.AlbumDAO;
import dao.MusicDAO;

/**
 * Servlet implementation class Library
 */
@WebServlet("/Library")
public class Library extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {

			String user_id = request.getParameter("id");
			//全アルバムの取得して購入済みに絞込
			AlbumDAO umd = new AlbumDAO();
			List<AlbumBeans> albList = umd.findAllPurchased(user_id);
			checkPrice(albList);
			request.setAttribute("user_id", user_id);
			if(albList != null) {//なんかとれた
				request.setAttribute("albList", albList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/library.jsp");
				dispatcher.forward(request, response);

			}else{//nullだった
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/library.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);
		} else {
			AlbumDAO umd = new AlbumDAO();
			List<AlbumBeans> albList = null;
			String search_value = request.getParameter("search_value");
			String searchPattern = request.getParameter("searchPattern");
			String user_id = request.getParameter("user_id");
			if(!search_value.isEmpty()) {
				switch(searchPattern) {
					case "keyword":
						albList = umd.KeywordSearchPurchased(search_value,user_id);
						break;
					default:
						albList = umd.SelectPatternSearchPurchased(user_id,searchPattern,search_value);
				}
			}else {
				albList = umd.findAllPurchased(user_id);
			}
			request.setAttribute("user_id", user_id);
			if(albList != null) {//なんかとれた
				checkPrice(albList);
				request.setAttribute("albList", albList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/library.jsp");
				dispatcher.forward(request, response);

			}else{//nullだった
				request.setAttribute("albList", albList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/library.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	/**
	 * アルバム価格未設定の場合収録曲の合計値を代入
	 * @param albList
	 */
	private void checkPrice(List<AlbumBeans> albList) {
		for(AlbumBeans list : albList) {
			if(list.getAl_price() == null) {
				MusicDAO msd = new MusicDAO();
				List<MusicBeans> musicList = msd.findByalbum_id(list.getAl_id());
				int setTotal = 0;
				for(MusicBeans  musicPrice : musicList) {
					setTotal += Integer.parseInt(musicPrice.getM_price());
					String total = String.valueOf(setTotal);
					list.setAl_price(total);
				}
			}
		}
	}
}