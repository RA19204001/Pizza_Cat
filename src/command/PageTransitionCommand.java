package command;

import context.ResponseContext;

public class PageTransitionCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext resc){

		resc.setTarget(getRequestContext().getCommandPath());
		return resc;
	}
}
