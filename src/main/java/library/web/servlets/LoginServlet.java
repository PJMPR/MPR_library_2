package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.User;
import library.web.SessionNames;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        System.out.println("Login Servlet Created!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        IDatabaseCatalog library = new HsqlCatalogFactory().library();
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        User user=null;
        List<User> users = library.users().withLogin(nickname);

        if(!users.isEmpty())
            {
            user = users.get(0);
            if (password.equals(user.getPassword()) ) {
                
            	out.println("Login: "+ nickname + "<br>Password: "+ password);
                out.println("<br>Zalogowano.");
                request.getSession().setAttribute(SessionNames.LoggedUser, user);


            } else {
                out.println("<br>Wprowadzono niepoprawne dane.");
            }
           }

    }


}
