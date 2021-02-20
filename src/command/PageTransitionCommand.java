package command;

import bean.Message;
import context.ResponseContext;

public class PageTransitionCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext resc){
		Message message=new Message();

		resc.setResult(message);
		resc.setTarget(getRequestContext().getCommandPath());
		return resc;
	}
}
