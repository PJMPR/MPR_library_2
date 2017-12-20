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
import library.domain.Book;
import library.domain.Publisher;
import library.domain.Author;

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
		boolean isAvaiable;
		if(request.getParameter("Availability") != null&&request.getParameter("Availability").equalsIgnoreCase("on"))
			isAvaiable = true;
		else
			isAvaiable = false;
		int publisherId = Integer.parseInt(request.getParameter("Publisher"));
		Publisher publisher = library.publishers().get(publisherId);
		int authorId = Integer.parseInt(request.getParameter("Author"));
		Author author = library.authors().get(authorId);

		
		if(title != null && !title.isEmpty() && language != null && !language.isEmpty() && 
				publisher != null && author != null) {
			Book book = new Book();
			book.setLanguage(language);
			book.setTitle(title);
			book.setAvailable(isAvaiable);
			book.setPublisher(publisher);
			book.setAuthor(author);
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


