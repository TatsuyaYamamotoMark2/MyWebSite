package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class User_delete
 */
@WebServlet("/User_delete")
public class User_delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		UserDAO umd = new UserDAO();
		boolean result = umd.deleteUser(request.getParameter("user_id"));
		if(result) {//処理成功
			String resultMessage = "削除しました";
			String buttonValue = "USER SEARCH";
			String link = "User_search";
			System.out.println("login_id"+request.getParameter("user_id")+resultMessage);
			request.setAttribute("resultMessage", resultMessage);
			request.setAttribute("buttonValue", buttonValue);
			request.setAttribute("link", link);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);

		}else{//エラー
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login_register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
