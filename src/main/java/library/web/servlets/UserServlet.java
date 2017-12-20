package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.User;


@WebServlet("UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
        System.out.println("User Servlet Created!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String adminString = request.getParameter("admin");
		Boolean admin = false;
		if(adminString != null){
			if(adminString.equals("on")){
				admin = true;
			}
		}
		User user = new User();
		
		
		if(nickname!=null && !nickname.isEmpty() 
				&& password!=null && !password.isEmpty()){
			out.println("Login: "+ nickname + "<br>Password: "+ password + "<br>Admin: "+ admin);
			user.setLogin(nickname);
			user.setPassword(password);
			user.setAdmin(admin);
			library.users().add(user);
			library.saveChanges();
			out.println("<br>Wprowadzono dane poprawnie.");
			
		}
		else{
			out.println("<br>Wprowadzono dane niepoprawnie.");
		}
		
	}

}
