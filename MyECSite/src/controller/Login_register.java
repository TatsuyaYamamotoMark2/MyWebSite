package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.UtillLogic;
import beans.UserBeans;
import dao.UserDAO;

@WebServlet("/Login_register")
public class Login_register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((UserBeans) session.getAttribute("usb") != null) {
			response.sendRedirect("Music_search");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//フォームからの値をrequestしてgetParameter
		String login_id = request.getParameter("login_id");
		String password = UtillLogic.convertPassword(request.getParameter("password"));

		//入力チェック
		if(!UtillLogic.isStringCheck(login_id) || !UtillLogic.isStringCheck(password)) {
			String errorMessage = "半角英数字のみ使用できます";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		}


		//Daoに送ってDBから取得してくる
		UserDAO umd = new UserDAO();
		UserBeans usb = umd.findByPass(login_id, password);

		if(usb != null) {//なんかとれた
			// ログインできたから一覧画面へ
			HttpSession session = request.getSession();
			session.setAttribute("usb", usb);
			response.sendRedirect("Music_search");

		}else{//nullだった
			String errorMessage = "ログインIDまたはパスワードが異なります。";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
