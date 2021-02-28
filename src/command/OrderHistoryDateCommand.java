package command;

import bean.OrderHistoryList;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.OrderDao;

public class OrderHistoryDateCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String user_number = reqc.getParameter("user_number")[0];

		int int_user_number = Integer.parseInt(user_number);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        OrderDao order = factory.getOrderDao();
        ConnectionManager cm = factory.getConnectionManager();
        OrderHistoryList orderHistoryList = new OrderHistoryList();

        cm.beginTransaction();

        orderHistoryList = order.getOrderDate(int_user_number);

        resc.setResult(orderHistoryList);
        resc.setTarget("orderHistoryDate");

        cm.commit();
        cm.closeConnection();

		return resc;
	}

}
