package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;

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
		HttpSession reservationOrderItem = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		IDatabaseCatalog library = new HsqlCatalogFactory().library();
		
		ArrayList ReservationList = (ArrayList) reservationOrderItem.getAttribute("myList");
		int deletedReservationOrderId = (Integer)reservationOrderItem.getAttribute("deletedItemId");
		ReservationList.remove(deletedReservationOrderId);
		reservationOrderItem.setAttribute("myList", deletedReservationOrderId);
	
	}
