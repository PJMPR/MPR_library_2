package library.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.domain.User;
import library.web.SessionNames;


public abstract class LoginFilter implements Filter {

    public LoginFilter() {
       
    }


	public void destroy() {
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		User u = (User) req.getSession().getAttribute(SessionNames.LoggedUser);
		
		
		if(IsUserLogged(u))
			chain.doFilter(request, response);
		else
			res.sendRedirect(getUrl());
			
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public abstract boolean IsUserLogged(User u);
	
	public abstract String getUrl();

}
