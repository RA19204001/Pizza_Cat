//01.29 移行 大川
//0203	改修　染谷
package filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter{
	public boolean isLoggedIn(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

		HttpSession session=req.getSession();

		if(session.getAttribute("loginuser") != null){
			return true;
		}else{
			return false;
		}
	}
}
