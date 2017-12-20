package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.ReservationOrder;
import library.web.SessionNames;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CartServlet() {
        super();
        System.out.println("CartServlet created!");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession reservationOrderItem = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		
		ArrayList<ReservationOrder> listOfBooks = (ArrayList<ReservationOrder>)reservationOrderItem.getAttribute(SessionNames.OrderedBookList);
	
		for(ReservationOrder o : listOfBooks) {
			
			try {
				library.reservationOrders().add(o);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
			library.saveChanges();
	
		out.println("<h1>Succesfully added</h1>");
	}
			

}
