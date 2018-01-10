package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Notification;



@WebServlet("/NotificationServlet")
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
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String message = request.getParameter("message");
		String type = request.getParameter("type");
		Notification notification = new Notification();
		
		
		
		if(message!=null && !message.isEmpty() && type!=null && !type.isEmpty()){
			notification.setMessage(message);
			notification.setNotification_type(type);
			try {
				library.notifications().add(notification);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("Operacja zakonczona sukcesem");
			library.saveChanges();
		}
		else {
			out.println("Popraw dane");
		}
		
		
	
	
	}

}
