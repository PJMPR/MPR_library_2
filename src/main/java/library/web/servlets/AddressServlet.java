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
import library.domain.Address;

/**
 * Servlet implementation class AdressServlet
 */
@WebServlet("/AdressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddressServlet() {
        super();
        System.out.println("AdressServlet created!");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postal");
		String street = request.getParameter("street");
		String apNumber = request.getParameter("apnumber");
		if(city != null && !city.isEmpty() && postalCode != null && !postalCode.isEmpty() && street != null && !street.isEmpty() && apNumber != null && !apNumber.isEmpty()){
			Address address = new Address(city, postalCode, street, apNumber);
			library.addresses().add(address);
			library.saveChanges();
			out.println("<h1>Succesfully added</h1>");
		}
		else
			out.println("<h1>All fields have to be filled</h1>");
			
	}

}
