package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MusicBeans;
import beans.UserBeans;
import dao.MusicDAO;

@WebServlet("/Ranking")
public class Ranking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

		if ((UserBeans) request.getSession().getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		} else {
			MusicDAO mDAO = new MusicDAO();
			List<MusicBeans> TopMusicList = mDAO.getTopRankMusicList();

			setRank(TopMusicList);

			request.setAttribute("musicList", TopMusicList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * 購入数をもとに同率を考慮して順位を設定
	 * @param TopMusicList
	 */
	private void setRank(List<MusicBeans> TopMusicList) {
		int preCount = 0;
		int j = 1;

		for (int i = 0; i < TopMusicList.size(); i++) {
			if(i>0) {
				preCount = TopMusicList.get(i-1).getCount();
			}
			if (preCount == TopMusicList.get(i).getCount()) {
				if(i != TopMusicList.get(i-1).getRank()) {
					TopMusicList.get(i).setRank(i-j);
					j++;
				}else {
				TopMusicList.get(i).setRank(i);
				}
			}else {
				TopMusicList.get(i).setRank(i + 1);
			}
		}
	}
}
