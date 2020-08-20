package nuit02;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String loginCheck = request.getParameter("loginCheck");
		
		request.setAttribute("userID", userID);
		
		RequestDispatcher dispatcher;
		if(loginCheck.equals("user")){
			request.setAttribute("name", URLEncoder.encode("전고객", "UTF-8"));
			dispatcher = request.getRequestDispatcher("09_userMain.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("name", URLEncoder.encode("성관리", "UTF-8"));
			dispatcher = request.getRequestDispatcher("09_managerMain.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
