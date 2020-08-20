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

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/AppContext")
public class AppContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
			
		processRequest(request, response);
	}



	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
			ServletContext application = getServletContext();	
	
	
			String resourcePath = application.getInitParameter("noticePath");
			String str = "";
			try (BufferedReader br = new BufferedReader(
					new InputStreamReader(
							application.getResourceAsStream(resourcePath)))) {
				
				while ((str = br.readLine()) != null) {
					System.out.println(str);
				}
				
			} catch (IOException e) {
				System.out.println("예외 발생" + e.getMessage());
			}
	}

	

}


