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
//
//		//ログインされてない時用
//		String judg = null;
//		//判定
//		boolean flag = true;
//
//		//WhereJspFilterの方
//		WhereJspFilter wherejf = new WhereJspFilter();
			try {
//
//				judg = wherejf.serchJsp(req, res);
//				System.out.println(judg);//受け取れてる
//
//			if(judg!=null) {
//
//				RequestDispatcher dispatcher = req.getRequestDispatcher(resc.getTarget());
//				dispatcher.forward(req,res);
//
//			}else {
//				flag = false;
//			}
//
//
//		//LoginCheckFilterの方
//			if(flag) {
//
//				LoginCheckFilter loginf=new LoginCheckFilter();
//
//
//					flag = loginf.loginCheck(req,res);
//
//
//		//ログイン出来ていなければ
//			}else if(flag == false){
//
//				//サーブレットパスを取得
//				String servletPath=req.getServletPath();
//
//				//ターゲットリソースのサーブレットパスを登録する
//				req.setAttribute("target",servletPath);
//
//				//ログインページへ戻す
//				RequestDispatcher dis=req.getRequestDispatcher("/login.jsp");
//	          			dis.forward(req,res);
//
//	}

		req.setAttribute("result",resc.getResult());

		RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());


			rd.forward(req,res);
		}catch(ServletException e){
			e.printStackTrace();
			//throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			e.printStackTrace();
			//throw new RuntimeException(e.getMessage(), e);
		}
	}
}
