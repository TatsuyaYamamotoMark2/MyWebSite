package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import beans.UserBeans;
import dao.AlbumDAO;

/**
 * Servlet implementation class Update_Album
 */
@WebServlet("/Update_Album")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Update_Album extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Album() {
        super();
        // TODO Auto-generated constructor stub
    }


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
			AlbumDAO alDAO = new AlbumDAO();
			RequestDispatcher dispatcher = null;


			switch(submit) {
				case "update":
					AlbumBeans album = alDAO.findById(id);
					request.setAttribute("album", album);
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_album.jsp");
					break;
				case "delete":
					boolean resultDelete = alDAO.removeById(id);
					request.setAttribute("resultMessage", "アルバムを削除しました");
					dispatcher = request.getRequestDispatcher("Admin_menu");
					break;

				case "new":
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update_album.jsp");
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
			String al_id = request.getParameter("al_id");
			String delete = request.getParameter("delete");
			String submit = request.getParameter("submit");
			String name = request.getParameter("name");
			Part part = null;
			String image;


				part = request.getPart("image");
				if(part.getSize() == 0) {
					if(request.getParameter("default") != null) {
						image =request.getParameter("default");
					}else {
						image ="no.jpg";
					}
				}else {
					image = this.getFileName(part);
					image = writeFile(part, image);
				}
			AlbumDAO alDAO = new AlbumDAO();
			switch(submit) {
				case "UPDATE":
					if(delete != null) {
						image ="no.jpg";
					}
					boolean resultUpdateAlbum = alDAO.updateAlbum(name,image,al_id);
					response.sendRedirect("Admin_menu?addFlg=5");
					break;
				case "ADD":
					boolean resultAddAlbum = alDAO.addAlbum(name, image);
					response.sendRedirect("Admin_menu?addFlg=6");
					break;
			}
		}
	}


	/**
	 * 画像が設定されていればファイル名を生成して保存、なければnotImageを設定
	 * @param part
	 * @param image
	 * @return
	 * @throws IOException
	 */
	private String writeFile(Part part, String image) throws IOException {
		if(!image.isEmpty()) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
			image = format.format(date) + "_" + image;
			part.write(UtillLogic.FILE_UPLOAD_PATH + image);
		}else {
			image ="no.jpg";
		}
		return image;
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
