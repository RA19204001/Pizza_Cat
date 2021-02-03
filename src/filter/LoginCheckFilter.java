package filter;

//01.29 移行 大川
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter{
	public boolean loginCheck(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

		boolean flag = false;
		System.out.println("LoginCheckFilter");
		HttpSession session=req.getSession();

		//ログイン判定用の変数
		if(session.getAttribute("loginuser") != null){
			flag = true;
			//System.out.println(session.getAttribute("loginuser"));
		}
		return flag;
	}
}
