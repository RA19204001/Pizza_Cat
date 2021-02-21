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
import filter.ManagerLoginCheckFilter;

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
		String judge;
		boolean flag = false;
		RequestDispatcher dispatcher;

		try{
			judge = cheker.isRequredLogin(req, res);
			if(judge.equals("manager")) {
				ManagerLoginCheckFilter mloginf=new ManagerLoginCheckFilter();
				flag = !(mloginf.isManagerLoggedIn(req,res));
			}else if(!(judge.equals("user"))){
				LoginCheckFilter loginf=new LoginCheckFilter();
				flag = !(loginf.isLoggedIn(req,res));
			}
			if(flag){
				if(judge.equals("manager")) {
					dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/managementLogin.jsp");
					Message message = new Message();
					message.setMessage("君ログインしてなくね？");
					resc.setResult(message);
				}else {
					dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					Message message = new Message();
					message.setMessage("君ログインしてなくね？");
					resc.setResult(message);
				}
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
