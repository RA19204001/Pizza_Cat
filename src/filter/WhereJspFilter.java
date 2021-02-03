//01.27 15:00 大川
//01.29 移行 大川
package filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WhereJspFilter{
	  public String serchJsp(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

		 String judg = null;

	    String path = req.getServletPath();

	    if(path.equals("/view") || path.equals("/start") || path.equals("/addUserResult" )|| path.equals("/addUser") || path.equals("/login")){
	    	judg = path;
	    }
	    return judg;
	}
}
