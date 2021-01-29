//浅倉 1/29
package command;

import bean.Message;
import context.ResponseContext;

public class LogoutCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		Message message=new Message();


		message.setFlag(true);
		resc.setResult(message);
		resc.setTarget("start");
		return resc;
	}



}
