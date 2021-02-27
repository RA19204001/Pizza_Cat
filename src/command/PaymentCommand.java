package command;

import java.util.ArrayList;

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

		System.out.println(card_id);





        Message message=new Message();

        if(!(card_id.equals("0"))) {



        	AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        	ConnectionManager cm = factory.getConnectionManager();
        	CardDao dao = factory.getCardDao();

        	cm.beginTransaction();

        	ArrayList array = dao.getCard(card_id);
        	Card card = new Card();
        	card.setCardInfo(array);

        	cm.commit();

        	cm.closeConnection();
        	resc.setResult(card);
        }


        resc.setTarget("confirmPurchase");

		return resc;
	}

}
