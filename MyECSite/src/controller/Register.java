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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String verification_password = request.getParameter("verification_password");
		String birth_date = request.getParameter("birth_date");
		String email = request.getParameter("email");

		//入力チェック
		if(!UtillLogic.isStringCheck(login_id) || !UtillLogic.isStringCheck(password)) {
			String errorMessage = "LOGIN ID,PASSWORDは半角英数字のみ使用できます";
			errorForward(request, response, errorMessage);
		}
		if(!UtillLogic.isMailPattern(email)) {
			String errorMessage = "メールアドレスの形式が正しくありません";
			errorForward(request, response, errorMessage);
		}

		if (!(password.equals(verification_password))) {
			String errorMessage = "パスワードと確認用パスワードが異なっています";
			errorForward(request, response, errorMessage);
		}else {
			UserDAO check = new UserDAO();
			boolean result = check.findByLoginId(login_id);
			if(result) {
				String errorMessage = "入力したユーザーログインIDは既に登録済みです";
				errorForward(request, response, errorMessage);
			}else {
				password = UtillLogic.convertPassword(password);
				UserDAO umd = new UserDAO();
				boolean newresult = umd.newUser(login_id, name, birth_date, password, email);
				if (newresult) {
					//登録完了
					UserDAO umd2 = new UserDAO();
					UserBeans usb = umd2.findByPass(login_id, password);
					HttpSession session = request.getSession();
					session.setAttribute("usb", usb);
					response.sendRedirect("Music_search");
				} else {
					String errorMessage = "入力された内容は正しくありません";
					errorForward(request, response, errorMessage);
				}
			}
		}
	}
	private void errorForward(HttpServletRequest request, HttpServletResponse response, String errorMessage)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(errorMessage);
		request.setAttribute("errorMessage", errorMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
		dispatcher.forward(request, response);
	}
}