package context;

import bean.Bean;

public interface ResponseContext {

	public Object getResponse();

	public Object getResult();

	public String getTarget();

	public void setResponse(Object object);

	public void setResult(Bean bean);

	public void setTarget(String target);

}
