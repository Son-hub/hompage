package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.nhn")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String[] arrUri = uri.split("/");
		uri = arrUri[2];
		System.out.println(uri);
		
		String site = null;
		if(uri.equals("main.nhn")) {
			site = "main.jsp";
		} else if (uri.equals("movierankk.nhn")) {
			site = "movierank.jsp";
		} else if (uri.equals("hugi.nhn")) {
			site = "hugi.jsp";
		}
		RequestDispatcher RD = request.getRequestDispatcher(site);
		RD.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
