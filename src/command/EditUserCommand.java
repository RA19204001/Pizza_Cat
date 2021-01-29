//浅倉 1/29
package command;

import bean.Message;
import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.UserDao;

public class EditUserCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext) {

        RequestContext reqc = getRequestContext();

        String id = reqc.getParameter("id")[0];
        String pass = reqc.getParameter("pass")[0];
        String name = reqc.getParameter("name")[0];
        String address = reqc.getParameter("address")[0];
        String age = reqc.getParameter("age")[0];
        String phoneNumber = reqc.getParameter("phoneNumber")[0];
        //古いID
        String oldId = reqc.getParameter("oldId")[0];

				int ages =  Integer.parseInt(age);

        User user = new User();
        user.setId(id);
        user.setPass(pass);
        user.setName(name);
        user.setAddress(address);
        user.setAge(ages);
        user.setPhoneNumber(phoneNumber);




        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        UserDao dao = factory.getUserDao();

        cm.beginTransaction();


        Message message=new Message();
        responseContext.setTarget("editUser");

        boolean flag=dao.isUniqueUserId(user.getId());
        if(flag){

            try{
                dao.editUser(oldId, user);
                //
                responseContext.setResult(user);

                responseContext.setTarget("editUserResult");
            }catch(RuntimeException e){
                cm.rollback();
                //
                message.setMessage("ユーザー情報を変更に失敗しました");
                responseContext.setResult(message);
                e.printStackTrace();

            }
        }else{
        	message.setMessage("そのIDは使われています。");
        	responseContext.setResult(message);
        }
        cm.commit();

        cm.closeConnection();



        return responseContext;
    }

}
