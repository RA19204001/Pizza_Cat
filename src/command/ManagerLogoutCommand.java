package command;

import bean.Message;
import context.ResponseContext;

public class ManagerLogoutCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		Message message=new Message();


		message.setFlag(true);
		resc.setResult(message);
		resc.setTarget("managementLogin");
		return resc;
	}

}
