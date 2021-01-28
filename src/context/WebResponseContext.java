package context;

import javax.servlet.http.HttpServletResponse;

import bean.Bean;

public class WebResponseContext implements ResponseContext {


	private HttpServletResponse response;

	private Object result;

	private String target;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = (HttpServletResponse) response;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Bean result) {
		this.result = result;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = "/WEB-INF/jsp/"+target+".jsp";
	}

	public WebResponseContext() {};

}
