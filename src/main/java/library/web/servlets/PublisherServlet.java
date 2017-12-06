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
import library.domain.Publisher;

@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PublisherServlet() {
        super();
        System.out.println("Publisher Servlet Created !");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String name = request.getParameter("name");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		Publisher publisher = new Publisher();

		if(name!=null && !name.isEmpty() && email!=null &&
				!email.isEmpty() && website!=null && !website.isEmpty() && phoneNumber >= 100000000 && phoneNumber <= 999999999){
			publisher.setName(name);
			publisher.setPhoneNumber(phoneNumber);
			publisher.setEmailAdress(email);
			publisher.setWebsite(website);
			library.publishers().add(publisher);
			out.println("Dane poprawne");
			library.saveChanges();
		}
		else{
			out.println("Trzeba podac wszystkie dane poprawnie");
		}
		
		
	}
}

