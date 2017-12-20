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


@WebFilter(urlPatterns={"notificationlist.jsp"})
public class NotificationListFilter extends LoginFilter implements Filter {

	@Override
	public boolean IsUserLoggedOut(User u) {
		return u!=null;
	}

	@Override
	public String getUrl() {
		return "login.jsp";
	}
       


}
