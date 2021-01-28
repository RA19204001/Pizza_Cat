package context;

public interface RequestContext {
	public String getCommandPath();

	public String[] getParameter(String string);

	public Object getRequest();

	public void setRequest(Object object);

}
