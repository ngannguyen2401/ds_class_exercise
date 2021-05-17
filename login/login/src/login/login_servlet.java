package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getServletPath());
		if (request.getParameter("uname").equals("long") && request.getParameter("upass").equals("dat")){
			response.setContentType("text/html");

		    PrintWriter out = response.getWriter();
		    out.println("<h1>" + "Login Successfully" + "</h1>");
		}
	}

}