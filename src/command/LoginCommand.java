package command;

import bean.Message;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.UserDao;
import exception.LoginFailedException;

public class LoginCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext responseContext) {

		RequestContext reqc = getRequestContext();
		String id = reqc.getParameter("id")[0];
		String pass = reqc.getParameter("pass")[0];



		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        UserDao dao = factory.getUserDao();

        cm.beginTransaction();
        Message message=new Message();

        //--------------------------------追加したプログラム
        User user =null;
        try {
        	user= dao.authenticateUser(id,pass);

        	responseContext.setResult(user);
        	responseContext.setTarget("start");
        }catch(LoginFailedException e) {

        	message.setMessage("IDまたはパスワードが間違っています。");

        	responseContext.setResult(message);

        	responseContext.setTarget("login");

        }


        //----------------------


		return responseContext;

	}

}
