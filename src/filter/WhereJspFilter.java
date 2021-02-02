//01.27 15:00 大川
//01.29 移行 大川
package filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WhereJspFilter{
	  public String serchJsp(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

		 String judg = null;

		System.out.println("WhereJspFilter");
	    String path = req.getServletPath();

	    if(path=="/view" || path=="/start" || path=="/addUserResult" || path=="/addUser" || path=="/login"){
	    	judg = path;
	      RequestDispatcher dispatcher = req.getRequestDispatcher(path);
	      dispatcher.forward(req,res);
	    }
	    return judg;
	}
}
