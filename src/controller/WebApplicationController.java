package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AbstractCommand;
import command.CommandFactory;
import context.RequestContext;
import context.ResponseContext;
import context.WebRequestContext;
import context.WebResponseContext;
import filter.LoginCheckFilter;
import filter.WhereJspFilter;

public class WebApplicationController implements ApplicationController {
	public RequestContext getRequest(Object request){

		RequestContext reqc=new WebRequestContext();

		reqc.setRequest(request);

		return reqc;
	}

	public ResponseContext handleRequest(RequestContext req){

		AbstractCommand command=CommandFactory.getCommand(req);
		command.init(req);

		ResponseContext resc = command.execute(new WebResponseContext());

		return resc;
	}

	public void handleResponse(RequestContext reqc,ResponseContext resc){

		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpServletResponse res = (HttpServletResponse)resc.getResponse();

		//ログインされてない時用
		String judg = null;
		//判定
		boolean flag = true;

		System.out.println("WhereJspFilteraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		//WhereJspFilterの方
		WhereJspFilter wherejf = new WhereJspFilter();
		try {

			judg = wherejf.serchJsp(req, res);

		}catch(ServletException e){

			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){

			throw new RuntimeException(e.getMessage(), e);

		}if(judg!=null) {
			try {
			RequestDispatcher dispatcher = req.getRequestDispatcher(judg);
		      dispatcher.forward(req,res);
			}catch(ServletException e){

				throw new RuntimeException(e.getMessage(), e);
			}catch(IOException e){

				throw new RuntimeException(e.getMessage(), e);

			}
		}


		//LoginCheckFilterの方
		if(flag) {

			LoginCheckFilter loginf=new LoginCheckFilter();
				try {

					flag = loginf.loginCheck(req,res);
				}catch(ServletException e){

					throw new RuntimeException(e.getMessage(), e);
				}catch(IOException e){

					throw new RuntimeException(e.getMessage(), e);
			}
		//ログイン出来ていなければ
		}else if(flag == false){
			try {
				//サーブレットパスを取得
			String servletPath=req.getServletPath();

			//ターゲットリソースのサーブレットパスを登録する
			req.setAttribute("target",servletPath);

			//ログインページへ戻す
			RequestDispatcher dis=req.getRequestDispatcher("/login.jsp");
	          	dis.forward(req,res);
			}catch(ServletException e){
				throw new RuntimeException(e.getMessage(), e);
			}catch(IOException e){
				throw new RuntimeException(e.getMessage(), e);
		}
	}

		req.setAttribute("result",resc.getResult());

		RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());

		try{
			rd.forward(req,res);
		}catch(ServletException e){
			throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
