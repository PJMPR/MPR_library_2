package library.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.web.SessionNames;

@WebServlet("/CartItemDeleteServlet")
public class CartItemDeleteServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CartItemDeleteServlet() {
        super();
        System.out.println("CartItemDeleteServlet created!");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		ArrayList ReservationList = (ArrayList) session.getAttribute(SessionNames.OrderedBookList);
		int deletedReservationOrderId = Integer.parseInt(request.getParameter("bookId"));
		ReservationList.remove(deletedReservationOrderId);
		session.setAttribute(SessionNames.OrderedBookList, ReservationList);
	
	}
}