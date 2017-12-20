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
 
 
@WebServlet("/ReservationOrderServlet")
public class ReservationOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ReservationOrderServlet() {
        super();
        System.out.println("ReservationOrder Servlet Created !");
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String bookTitle = request.getParameter("bookTitle");
        String date = request.getParameter("date");
 
       
        if(bookTitle!=null && !bookTitle.isEmpty()){
            out.println("bookTitle"+ bookTitle);
        }
        if(date!=null && !date.isEmpty()){
            out.println("User"+date);
        }
       
        out.println("<h1>ReservationOrderServlet </h1>");
       
   
   
    }
 
}
