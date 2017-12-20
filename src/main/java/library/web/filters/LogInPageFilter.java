package library.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import library.domain.User;


@WebFilter(urlPatterns={"login.jsp"})
public class LogInPageFilter extends LoginFilter implements Filter {

	@Override
	public boolean IsUserLogged(User u) {
		return u==null;
	}

	@Override
	public String getUrl() {
		return "/";
	}
       
   

}
