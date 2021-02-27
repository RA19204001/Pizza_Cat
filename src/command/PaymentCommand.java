package command;

import bean.Card;
import bean.Message;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CardDao;
import dao.ConnectionManager;

public class PaymentCommand extends AbstractCommand {


	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();

		String card_id = reqc.getParameter("card_id")[0];

		Card card = new Card();

		System.out.println(card_id);






        if(!(card_id.equals("0"))) {



        	AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        	ConnectionManager cm = factory.getConnectionManager();
        	CardDao dao = factory.getCardDao();

        	cm.beginTransaction();

        	card = dao.getCardNumber(card_id);
        	cm.commit();

        	cm.closeConnection();
        	resc.setResult(card);
        }else {

        	Message message=new Message();

    		resc.setResult(message);
        }


        resc.setTarget("confirmPurchase");

		return resc;
	}

}
