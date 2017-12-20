package library.web.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.ReservationOrder;

@WebServlet("/ReservationOrderServlet")

public class ReservationOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ReservationOrderServlet() {
		super();
		System.out.println("ReservationOrder Servlet Created !");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		ReservationOrder order = new ReservationOrder();
		order.setBook(library.books().get(bookId));
		order.setUser(library.users().get(userId));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		order.setDate(calendar.getTime().getTime());
		
		try {
						library.reservationOrders().add(order);
						library.saveChanges();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		out.println("<h1>ReservationOrderServlet </h1>");
		
	
	}
	
}



