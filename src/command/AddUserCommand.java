package command;

import bean.Message;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.UserDao;
import exception.IntegrationException;

public class AddUserCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {

        RequestContext reqc = getRequestContext();

        String address = reqc.getParameter("address")[0];
        String age = reqc.getParameter("age")[0];
        String id = reqc.getParameter("id")[0];
        String name = reqc.getParameter("name")[0];
        String pass = reqc.getParameter("pass")[0];
        String pass2 = reqc.getParameter("pass2")[0];
        String phoneNumber = reqc.getParameter("phoneNumber")[0];

				int ages =  Integer.parseInt(age);

        User user = new User();
        user.setAddress(address);
        user.setAge(ages);
        user.setId(id);
        user.setName(name);
        user.setPass(pass);
        user.setPhoneNumber(phoneNumber);


        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        UserDao dao = factory.getUserDao();

        cm.beginTransaction();


        Message message=new Message();

        boolean flag=dao.isUniqueUserId(user.getId());

        if (!flag) {

        	message.setMessage("そのIDは使われています。");
        	responseContext.setTarget("addUser");

        } else if (!pass.equals(pass2)) {

        	cm.rollback();
        	message.setMessage("設定したパスワードと確認用パスワードが一致していません");
        	responseContext.setTarget("addUser");

        } else {

	        try{
		        dao.addUser(user);
		        message.setMessage("登録完了しました");
	        }catch(IntegrationException e){
	        	cm.rollback();
	        	message.setMessage("登録失敗しました");
		        e.printStackTrace();
	        }
	        responseContext.setTarget("addUserResult");
        }

        cm.commit();

        cm.closeConnection();

        responseContext.setResult(message);


        return responseContext;
    }
}
