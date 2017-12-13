package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AlbumBeans;
import beans.MusicBeans;
import dao.AlbumDAO;
import dao.MusicDAO;

@WebServlet("/Music_search")
public class Music_search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Music_search() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//全アルバムの取得
		AlbumDAO umd = new AlbumDAO();
		List<AlbumBeans> albList = umd.findAll();
		checkPrice(albList);

		if(albList != null) {//なんかとれた
			request.setAttribute("albList", albList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music_search.jsp");
			dispatcher.forward(request, response);

		}else{//nullだった
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music_search.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け退散おまじない
		request.setCharacterEncoding("UTF-8");
		AlbumDAO umd = new AlbumDAO();
		List<AlbumBeans> albList = null;
		String search_value = request.getParameter("search_value");
		String searchPattern = request.getParameter("searchPattern");

		if(!search_value.isEmpty()) {
			switch(searchPattern) {
				case "keyword":
					albList = umd.KeywordSearch(search_value);
					break;
				default:
					albList = umd.SelectPatternSearch(searchPattern,search_value);
			}
		}else {
			albList = umd.findAll();
		}
		if(albList != null) {//なんかとれた
			checkPrice(albList);
			request.setAttribute("albList", albList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music_search.jsp");
			dispatcher.forward(request, response);

		}else{//nullだった
			request.setAttribute("albList", albList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/music_search.jsp");
			dispatcher.forward(request, response);
		}
	}
	//アルバム価格未設定の場合収録曲の合計値を代入
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
