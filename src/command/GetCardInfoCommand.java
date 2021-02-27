package command;

import java.util.ArrayList;

import bean.Card;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.CardDao;
import dao.ConnectionManager;

public class GetCardInfoCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {

		RequestContext reqc = getRequestContext();
		String card_id = reqc.getParameter("card_id")[0];

		Card card = new Card();
		card.setCard_id(card_id);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        CardDao dao = factory.getCardDao();

        cm.beginTransaction();

        ArrayList cardList = dao.getCard(card_id);
        card.setCardInfo(cardList);

        responseContext.setResult(card);

        responseContext.setTarget("editCard");

        cm.commit();

        cm.closeConnection();

		return responseContext;
	}

}
