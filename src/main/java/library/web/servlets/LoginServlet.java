package library.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import library.dao.repositories.IDatabaseCatalog;
import library.dao.repositories.impl.HsqlCatalogFactory;
import library.domain.User;

@WebServlet("LoginServlet")
public class LoginServlet {
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
        User user = new User();

        if ((nickname == user.getLogin()) && (password == user.getPassword()) ) {
            out.println("Login: "+ nickname + "<br>Password: "+ password);
            Cookie loginCookie = new Cookie("user",nickname);
            loginCookie.setMaxAge(120*60);
            response.addCookie(loginCookie);
            response.sendRedirect("login.jsp");
            out.println("<br>Zalogowano.");



        } else {
            out.println("<br>Wprowadzono niepoprawne dane.");
        }

    }


}
