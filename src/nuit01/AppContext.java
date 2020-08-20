package nuit01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppContext")
public class AppContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}



	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
		
	
		throw IOException{
			ServletContext application = getServletContext();	
	
	
			String resourcePath = application.getInitParameter("noticePath");
			String str = "";
			try (BufferedReader br = new BufferedReader(
					new InputStreamReader(
							application.getResourceAsStream(resourcePath)))) {
				
				while ((str = br.readLine()) != null) {
					out.print(str);
				}
				
			} catch (IOException e) {
				out.print("예외 발생" + e.getMessage());
			}
	}

	

}


