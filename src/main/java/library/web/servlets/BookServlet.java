package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.calendar.BaseCalendar.Date;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
        System.out.println("Book Servlet Created !");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String language = request.getParameter("Language");
		String title = request.getParameter("Title");
		String isAvaiable = request.getParameter("Avaiability");
		String publisher = request.getParameter("Publisher");
		String author = request.getParameter("Author");

		
		if(title != null && !title.isEmpty() && language != null && !language.isEmpty() && isAvaiable != null && isAvaiable.isEmpty()
				 && publisher != null && publisher.isEmpty() && author != null && author.isEmpty()) {
			Book book = new Book();
			library.books().add(book);
			library.saveChanges();
			out.println("Changes saved!");
		}
		else
		{
			out.println("Fill out all the fields!");
		}
	}
	
}


