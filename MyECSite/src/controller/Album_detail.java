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

import base.UtillLogic;
import beans.AlbumBeans;
import beans.Buy_historyBeans;
import beans.CartBeans;
import beans.MusicBeans;
import beans.UserBeans;
import dao.AlbumDAO;
import dao.Buy_historyDAO;
import dao.MusicDAO;

/**
 * Servlet implementation class Album_detail
 */
@WebServlet("/Album_detail")
public class Album_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {
			String album_id = request.getParameter("al_id");
			MusicDAO umd = new MusicDAO();
			List<MusicBeans> musicList = umd.findByalbum_id(album_id);
			AlbumDAO ALD = new AlbumDAO();
			AlbumBeans albumBean = ALD.findById(album_id);

			List<CartBeans> cart = (List<CartBeans>) session.getAttribute("cart");

			if(albumBean.getAl_price() == null) {
				setAlbumTotalPrice(musicList, albumBean);
			}
			checkAddCart(musicList,cart, albumBean);
			checkPurchased(session, musicList,albumBean);


			UtillLogic.redirectResultMessage(request);

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
	 * アルバム内に購入済みの曲があるかチェックする
	 * @param session
	 * @param musicList
	 */
	private void checkPurchased(HttpSession session, List<MusicBeans> musicList,AlbumBeans albumBean) {
		UserBeans login_user = (UserBeans) session.getAttribute("usb");
		Buy_historyDAO BHD = new Buy_historyDAO();
		List<Buy_historyBeans> userHistoryList = new ArrayList<Buy_historyBeans>();
		userHistoryList = BHD.getHistory(login_user.getId());
		if(userHistoryList != null) {
			for(Buy_historyBeans purchasedMusic : userHistoryList) {
				for(MusicBeans  music : musicList) {
					if(music.getM_id().equals(purchasedMusic.getM_id())) {
						albumBean.setPurchased(true);
						music.setPurchased(true);
					}
				}
			}
		}
	}

	/**
	 * アルバムの合計金額を設定する
	 * @param musicList
	 * @param albumBean
	 */
	private void setAlbumTotalPrice(List<MusicBeans> musicList, AlbumBeans albumBean) {
		int setTotal = 0;
		for(MusicBeans  music : musicList) {
			setTotal += Integer.parseInt(music.getM_price());
			String total = String.valueOf(setTotal);
			albumBean.setAl_price(total);
		}
	}

	/**
	 * アルバムに存在する楽曲がカートに追加されているかをチェックする
	 * @param musicList
	 * @param cart
	 */
	private void checkAddCart(List<MusicBeans> musicList, List<CartBeans> cart, AlbumBeans albumBean) {
		for(MusicBeans  music : musicList) {
			if (cart != null) {
				for(CartBeans check : cart) {
					if(check.getM_id().equals(music.getM_id())) {
						albumBean.setAdd_cart(true);
						music.setAdd_cart(true);
						break;
					}
				}
			}
		}
	}
}
