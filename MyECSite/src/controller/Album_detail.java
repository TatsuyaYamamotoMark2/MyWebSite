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
 * Servlet implementation class Album_detail
 */
@WebServlet("/Album_detail")
public class Album_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Album_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {
			String album_id = request.getParameter("al_id");
			//Daoに送ってDBから取得してくる
			MusicDAO umd = new MusicDAO();
			List<MusicBeans> musicList = umd.findByalbum_id(album_id);
			AlbumDAO ALD = new AlbumDAO();
			AlbumBeans albumBean = ALD.findById(album_id);
			if(albumBean.getAl_price() == null) {
				int setTotal = 0;
				for(MusicBeans  musicPrice : musicList) {
					setTotal += Integer.parseInt(musicPrice.getM_price());
					String total = String.valueOf(setTotal);
					albumBean.setAl_price(total);
				}
			}

			if(musicList != null) {//なんかとれた
				request.setAttribute("albumBean", albumBean);
				request.setAttribute("musicList", musicList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/album_details.jsp");
				dispatcher.forward(request, response);

			}else{//nullだった
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
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
