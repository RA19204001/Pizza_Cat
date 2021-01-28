package context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext {

	private HttpServletRequest request;

	private Map parameters;

	public String getCommandPath() {
		return request.getServletPath().substring(1);
	}

	public String[] getParameter(String key) {
		return (String[])parameters.get(key);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = (HttpServletRequest) request;
		this.parameters = this.request.getParameterMap();
	}

	public WebRequestContext() {};

}
