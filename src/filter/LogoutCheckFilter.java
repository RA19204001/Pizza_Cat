// 内田1/27
//01.29 移行 大川
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Message;
import bean.User;

public class LogoutCheckFilter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config)throws ServletException{
		this.config=config;
	}
	public void destroy(){}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException,ServletException{

		HttpServletRequest hreq=(HttpServletRequest)req;
		HttpServletResponse hres=(HttpServletResponse)res;
		HttpSession session=hreq.getSession();

		System.out.println(((User)(session.getAttribute("loginuser"))).getName());

		// ログアウトしようとしてるか判定
		// flagがtrueなら
		Message message=(Message)(req.getAttribute("result"));

		if (message.getFlag()) {

			// ログアウトする
			session.setAttribute("loginuser",null);

		}
		// filterchain
		chain.doFilter(hreq, hres);

	}

}
