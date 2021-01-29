//01.27 15:00 大川
//01.29 移行 大川
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class WhereJspFilter implements Filter {

	public void init(FilterConfig config)throws ServletException{}

	  public void destroy(){}

	  public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{

	    HttpServletRequest httpRequest=(HttpServletRequest)req;
	    String path = httpRequest.getServletPath();

	    if(path=="/view" || path=="/start" || path=="/addUserResult" || path=="/addUser" || path=="/login"){
	      RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(path);
	      dispatcher.forward(req,res);
	    }
	    else{
	      chain.doFilter(req,res);
	    }
	  }
}
