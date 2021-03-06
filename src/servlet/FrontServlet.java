//2.02 大川
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.RequestContext;
import context.ResponseContext;
import controller.ApplicationController;
import controller.WebApplicationController;

//@MultipartConfig(location="c:\\pizza")
public class FrontServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// doPostを呼び出す
		doPost(req, res);

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");

		ApplicationController app=new WebApplicationController();

		RequestContext reqc=app.getRequest(req);

		ResponseContext resc=app.handleRequest(reqc);

		resc.setResponse(res);

		app.handleResponse(reqc,resc);

	}
}
