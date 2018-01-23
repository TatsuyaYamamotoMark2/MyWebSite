package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.UtillLogic;
import beans.UserBeans;
import dao.UserDAO;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("user_id");
		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String verification_password = request.getParameter("verification_password");
		String birth_date = request.getParameter("birth_date");
		String email =request.getParameter("email");

		UserDAO umdf = new UserDAO();
		UserBeans usd = umdf.findById(id);

		if(password.isEmpty() && verification_password.isEmpty() ){
			UserDAO ud = new UserDAO();
			boolean result1 = ud.updateUser1(login_id,name,birth_date,email,id);
			if(result1) {//処理成功
				String resultMessage ="パスワード以外更新しました";
				this.resultFowerd(request, response,resultMessage,usd);
			}else {
				String resultMessage ="更新に失敗しました";
				this.errorFowerd(request, response,resultMessage,usd);
			}
		}else if(!(password.equals(verification_password))) {
			String resultMessage ="パスワードと確認用パスワードが異なっています";
			this.errorFowerd(request, response,resultMessage,usd);
		}else {
			password = UtillLogic.convertPassword(password);
			UserDAO umd = new UserDAO();
			boolean result = umd.updateUser(login_id,name,password,birth_date,email,id);
			if(result) {//処理成功
				String resultMessage ="更新しました";
				this.resultFowerd(request, response,resultMessage,usd);
			}else{//エラー
				String resultMessage ="更新に失敗しました";
				this.errorFowerd(request, response,resultMessage,usd);
			}
		}
	}

	/**
	 * リクエストにエラーメッセージを設定しユーザー詳細画面へフォワード
	 * @param request
	 * @param response
	 * @param resultMessage
	 * @param usd
	 * @throws ServletException
	 * @throws IOException
	 */
	private void errorFowerd(HttpServletRequest request, HttpServletResponse response, String resultMessage, UserBeans usd)
			throws ServletException, IOException {
		request.setAttribute("usd", usd);
		request.setAttribute("errorMessage", resultMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * リクエストに成功メッセージを設定しユーザー詳細画面へフォワード
	 * @param request
	 * @param response
	 * @param resultMessage
	 * @param usd
	 * @throws ServletException
	 * @throws IOException
	 */
	private void resultFowerd(HttpServletRequest request, HttpServletResponse response, String resultMessage,UserBeans usd)
			throws ServletException, IOException {
		request.setAttribute("usd", usd);
		request.setAttribute("resultMessage", resultMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
	}
}