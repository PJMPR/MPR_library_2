package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Author;

public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthorServlet() {
        super();
        System.out.println("Author Servlet Created !");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String name = request.getParameter("Name");
		String secondname = request.getParameter("Secondname");
		String surname = request.getParameter("Surname");
		
		if(name != null && name.isEmpty() && secondname != null && secondname.isEmpty() && surname != null && surname.isEmpty()){
			Author author = new Author();
			library.authors().add(author);
			library.saveChanges();
			out.println("Changes saved!");
		}
		else
		{
			out.println("Fill out all the fields!");
		}
		
	}	
}


