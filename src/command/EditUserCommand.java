//浅倉 1/29
//浅倉 2/2
//五   2/2
//染谷 2/2
package command;

import bean.Message;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.UserDao;
import exception.EditUserFailedException;

public class EditUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext) {

        RequestContext reqc = getRequestContext();

        String id = reqc.getParameter("id")[0];
        String pass = reqc.getParameter("pass")[0];
        String pass2 = reqc.getParameter("pass2")[0];
        String name = reqc.getParameter("name")[0];
        String address = reqc.getParameter("address")[0];
        String age = reqc.getParameter("age")[0];
        String phoneNumber = reqc.getParameter("phoneNumber")[0];
        String number=reqc.getParameter("number")[0];
        //古いID
        String oldId = reqc.getParameter("oldId")[0];

				int ages =  Integer.parseInt(age);
				int numbers=Integer.parseInt(number);

        User user = new User();
        user.setId(id);
        user.setPass(pass);
        user.setName(name);
        user.setAddress(address);
        user.setAge(ages);
        user.setPhoneNumber(phoneNumber);
        user.setNumber(numbers);





        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        UserDao dao = factory.getUserDao();

        cm.beginTransaction();


        Message message=new Message();
        responseContext.setTarget("editUser");
        //変更前のIDと変更後のIDが同じ場合は問題なく変更できる
        boolean flag=false;

        if(oldId.equals(id)) {
        	flag=true;
        }else {
        	if(dao.isUniqueUserId(id)) {
        		flag=true;
        	}
        }

        if (!flag) {
        	message.setMessage("そのIDは使われています。");
    	    responseContext.setResult(message);

        } else if (!pass.equals(pass2)) {
        	// パスワードの重複処理
        	cm.rollback();
        	message.setMessage("設定したパスワードと確認用パスワードが一致していません");
        	responseContext.setResult(message);
        	responseContext.setTarget("editUser");

        } else {
        	try{
        		// 成功時の処理
        	    dao.editUser(oldId, user);
        	    responseContext.setResult(user);
                responseContext.setTarget("editUserResult");

            }catch(EditUserFailedException e){
                 cm.rollback();
                 message.setMessage("ユーザー情報の変更に失敗しました");
                 responseContext.setResult(message);
                 e.printStackTrace();
        	}

        }


        cm.commit();

        cm.closeConnection();

        return responseContext;
    }

}
