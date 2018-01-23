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

import beans.UserBeans;
import dao.UserDAO;

@WebServlet("/User_search")
public class User_search extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login_register");
			dispatcher.forward(request, response);

		} else {
			//Daoに送ってDBから取得してくる
			UserDAO umd = new UserDAO();
			List<UserBeans> usbList = umd.findAll();

			if(usbList != null) {//なんかとれた
				request.setAttribute("usbList", usbList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_search.jsp");
				dispatcher.forward(request, response);

			}else{//nullだった
				RequestDispatcher dispatcher = request.getRequestDispatcher("");
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//フォームからの値をrequestしてgetParameter
		String login_id    = request.getParameter("login_id");
		String name        = request.getParameter("name");
		String birth_date_form = request.getParameter("birth_date_from");
		String birth_date_to = request.getParameter("birth_date_to");
		UserDAO umd = new UserDAO();
		List<UserBeans> usbList = umd.userSearch(login_id,name,birth_date_form,birth_date_to);

		if(usbList != null) {//なんかとれた
			request.setAttribute("usbList", usbList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_search.jsp");
			dispatcher.forward(request, response);

		}else{//nullだった,全フォーム未入力なので以下findAll
			List<UserBeans> usl1 = umd.findAll();
			if(usl1 != null) {
				request.setAttribute("usl", usl1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_search.jsp");
				dispatcher.forward(request, response);
			}else{

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_search.jsp");
				dispatcher.forward(request, response);
			}
	    }
    }
}
