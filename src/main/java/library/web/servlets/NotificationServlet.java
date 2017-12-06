package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("NotificationServlet")
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NotificationServlet() {
        super();
        System.out.println("Notification Servlet Created !");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String message = request.getParameter("message");
		String type = request.getParameter("type");
		
		if(message!=null && !message.isEmpty() && type!=null && !type.isEmpty()){
			out.println("Message: "+ message + ", type " + type);
		}
		
		
		
	
	
	}

}
