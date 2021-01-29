package command;

import context.ResponseContext;

public class AddUserInputCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){

		resc.setTarget("addUser");
		return resc;
	}
}
