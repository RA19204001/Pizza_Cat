package filter;

//01.29 移行 大川
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	private FilterConfig config;

	public void init(FilterConfig config)throws ServletException{
		this.config=config;
	}
	public void destroy(){}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
		HttpServletRequest hreq=(HttpServletRequest)req;
		HttpServletResponse hres=(HttpServletResponse)res;
		HttpSession session=hreq.getSession();

		//ログイン判定用の変数

		boolean login=false;
		if(session.getAttribute("loginuser") != null){
			login = true;								//ヘッダ情報
		}
		//ログインできていれば
		if(login == true){
			//本来のページへ移動
			chain.doFilter(hreq,hres);

		//ログインできていない場合
		}else{
			//サーブレットパスを取得
			String servletPath=hreq.getServletPath();

			//ターゲットリソースのサーブレットパスを登録する
			hreq.setAttribute("target",servletPath);

			//ログインページへ戻す
			RequestDispatcher dis=req.getRequestDispatcher("/login.jsp");
            dis.forward(req,res);
		}
	}
}
