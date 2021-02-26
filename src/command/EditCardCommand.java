package command;

import bean.Card;
import bean.Message;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CardDao;
import dao.ConnectionManager;
import exception.EditCardFailedException;

public class EditCardCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {

		RequestContext reqc = getRequestContext();

		String creditnumber = reqc.getParameter("creditnumber")[0];
        String security_code = reqc.getParameter("security_code")[0];
        String expiration_year = reqc.getParameter("expiration_year")[0];
        String expiration_month = reqc.getParameter("expiration_month")[0];
        String mail_address = reqc.getParameter("mail_address")[0];
        //古い
        String oldCreditnumber = reqc.getParameter("oldcard_id")[0];

        String expiration_date = "20" + expiration_year + expiration_month + "01";

        Card card = new Card();
        card.setCreditnumber(creditnumber);
        card.setSecurity_code(security_code);
        card.setExpiration_date(expiration_date);
        card.setMail_address(mail_address);

        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        CardDao cd = factory.getCardDao();

        cm.beginTransaction();

        Message message=new Message();
        responseContext.setTarget("editCard");

        boolean flag=false;

        if(oldCreditnumber.equals(creditnumber)) {
        	flag=true;
        }else {
        	if(cd.isUniqueCardId(creditnumber)) {
        		flag=true;
        	}
        }

        if(flag=false) {
        	message.setMessage("その番号は使われています。");
    	    responseContext.setResult(message);
        }else {
        	try{
        	    cd.editCard(oldCreditnumber, card);

        	    responseContext.setResult(card);

                responseContext.setTarget("editCardResult");
            }catch(EditCardFailedException e){
                 cm.rollback();

                 message.setMessage("カード情報の変更に失敗しました");
                 responseContext.setResult(message);
                 e.printStackTrace();
        	}
        }

        cm.commit();

        cm.closeConnection();



        return responseContext;
	}

}
