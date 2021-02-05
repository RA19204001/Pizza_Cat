//0203 染谷
//0203 浅倉
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import command.AbstractCommand;
import command.CommandFactory;
import context.RequestContext;
import context.ResponseContext;
import context.WebRequestContext;
import context.WebResponseContext;
import filter.LoginCheckFilter;
import filter.LoginNecessityChecker;

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

		LoginNecessityChecker cheker = new LoginNecessityChecker();
		boolean flag;
		RequestDispatcher dispatcher;

		try{
			flag = cheker.isRequredLogin(req, res);
			if(flag){
				LoginCheckFilter loginf=new LoginCheckFilter();
				flag = !(loginf.isLoggedIn(req,res));
			}
			if(flag){
				dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				Message message = new Message();
				message.setMessage("君ログインしてなくね？");
				resc.setResult(message);
			}else{
				req.setAttribute("result",resc.getResult());
				dispatcher = req.getRequestDispatcher(resc.getTarget());
			}
			dispatcher.forward(req,res);
		}catch(ServletException e){
			e.printStackTrace();
			//throw new RuntimeException(e.getMessage(), e);
		}catch(IOException e){
			e.printStackTrace();
			//throw new RuntimeException(e.getMessage(), e);
		}
	}
}
