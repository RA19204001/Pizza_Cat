
package command;

import bean.Card;
import bean.Message;
//10.29 移行 大川
//02.04 大川
//2/16 手直し
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CardDao;
import dao.ConnectionManager;
import dao.UserDao;
import exception.IntegrationException;

public class AddCardCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext responseContext) {

        RequestContext reqc = getRequestContext();

        String creditnumber = reqc.getParameter("creditnumber")[0];
        String security_code = reqc.getParameter("security_code")[0];
        String expiration_year = reqc.getParameter("expiration_year")[0];
        String expiration_month = reqc.getParameter("expiration_month")[0];
        String mail_address = reqc.getParameter("mail_address")[0];

        String expiration_date = "20" + expiration_year + expiration_month + "01";

        Card card = new Card();
        card.setCreditnumber(creditnumber);
        card.setSecurity_code(security_code);
        card.setExpiration_date(expiration_date);
        card.setMail_address(mail_address);


        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        CardDao dao = factory.getCardDao();
        UserDao udao = factory.getUserDao();

        cm.beginTransaction();


        Message message=new Message();

        boolean flag = true;

        flag=dao.isUniqueCardId(creditnumber);

        if(flag) {
        	try{
                dao.addCard(card);
                message.setMessage("登録完了しました");
            }catch(IntegrationException e){
                cm.rollback();
                message.setMessage("登録に失敗しました");
                e.printStackTrace();

            }
            responseContext.setTarget("addCardResult");
        }else{
        	message.setMessage("その番号は使われています。");
            responseContext.setTarget("addCard");
        }

        String userId = reqc.getParameter("userId")[0];

        Card card_id = dao.getCardId(creditnumber,security_code);

        System.out.println(card_id.getCard_id());

        udao.addCardId(userId,card_id);

        cm.commit();

        cm.closeConnection();

        responseContext.setResult(message);

        return responseContext;
    }
}
