package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import base.UtillLogic;
import beans.AlbumBeans;
import beans.ArtistBeans;
import beans.MusicBeans;
import beans.UserBeans;
import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.MusicDAO;

/**
 * Servlet implementation class Update_Music
 */
@WebServlet("/Update_Music")
@MultipartConfig(location="/tmp", maxFileSize=78643200)
public class Update_Music extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Music() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {

			String album_id = request.getParameter("select");

			MusicDAO mDAO = new MusicDAO();
			List<MusicBeans> albumDetail = mDAO.findByalbum_id(album_id);

			AlbumDAO alDAO  = new AlbumDAO();
			AlbumBeans album = alDAO.findById(album_id);

			ArtistDAO arDAO = new ArtistDAO();
			List<ArtistBeans> artist = arDAO.findAll();

			int j = albumDetail.size();
			for(int i = 0;10-j > i;i++) {
				MusicBeans music = new MusicBeans();
				music.setTrack_no(String.valueOf(j + i + 1));
				albumDetail.add(music);
			}

			request.setAttribute("albumDetail", albumDetail);
			request.setAttribute("artist", artist);
			request.setAttribute("album", album);
			UtillLogic.redirectResultMessage(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_music.jsp");
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
			boolean resultUpdate = false;
			String al_id = request.getParameter("al_id");
			for(int i = 1;i <= 10; i++) {

				String no = request.getParameter("no"+i);
				String m_name = request.getParameter("m_name"+i);
				String artist_id = request.getParameter("artist"+i);
				String price = request.getParameter("price"+i);
				String mp3 = request.getParameter("mp3File"+i);
				String dl = request.getParameter("waveFile"+i);
				String id = request.getParameter("m_id"+i);
				String delete = request.getParameter("delete"+i);
				Part mp3P = null;
				Part dlP = null;


				mp3P = request.getPart("mp3File"+i);
				dlP= request.getPart("waveFile"+i);

				if(m_name.isEmpty() && price.isEmpty() && dlP.getSize() == 0) {
					resultUpdate = false;
				}else {
					mp3 = this.getFileName(mp3P);
					dl =  this.getFileName(dlP);
					mp3 = writemp3File(mp3P, mp3);
					dl = writeWAVFile(dlP, dl);

					MusicDAO mDAO = new MusicDAO();
					resultUpdate = mDAO.updateMusic(no,m_name,artist_id,price,mp3,dl,al_id);

					if(delete != null) {
						mDAO.removeMusicByM_id(id);
						resultUpdate = true;
					}

				}

			}

			if(!resultUpdate) {
				response.sendRedirect("Update_Music?select="+al_id+"&addFlg=10");
			}else {
				response.sendRedirect("Update_Music?select="+al_id+"&addFlg=11");
			}
		}
	}
	/**
	 * WAVEが設定されていればファイル名を生成して保存、なければnull
	 * @param part
	 * @param image
	 * @return
	 * @throws IOException
	 */
	private String writeWAVFile(Part part, String file) throws IOException {
		if(!file.isEmpty()) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
			file = format.format(date) + "_" + file;
			part.write(UtillLogic.wave_UPLOAD_PATH + file);
		}else {
			file = null;
		}
		return file;
	}
	/**
	 * mp3が設定されていればファイル名を生成して保存、なければnull
	 * @param part
	 * @param image
	 * @return
	 * @throws IOException
	 */
	private String writemp3File(Part part, String file) throws IOException {
		if(!file.isEmpty()) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
			file = format.format(date) + "_" + file;
			part.write(UtillLogic.MP3_UPLOAD_PATH + file);
		}else {
			file = null;
		}
		return file;
	}
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
