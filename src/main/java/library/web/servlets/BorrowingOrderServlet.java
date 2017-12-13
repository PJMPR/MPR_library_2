package library.web.servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Date;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.Book;
 
 
@WebServlet("/BorrowingOrderServlet")
public class BorrowingOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public BorrowingOrderServlet() {
        super();
        System.out.println("BorrowingOrder Servlet Created !");
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        String title = request.getParameter("bookTitle");
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
       
       
       
        if(title!=null && !title.isEmpty()){
            out.println("Title: "+ title);
        }
        if(dateFrom!=null && !dateFrom.isEmpty()){
            out.println("Date: "+ dateFrom);
        }
        if(dateTo!=null && !dateTo.isEmpty()){
            out.println("Date: "+ dateTo);
        }
       
        out.println("<h1></h1>");
       
   
   
    }
 
}
