//2.28 浅倉
package command;


import bean.Message;
import bean.OrderHistoryList;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.OrderHistoryDao;
import exception.DisplayOrderHistoryFailedException;

public class DisplayOrderHistoryCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String order_id = reqc.getParameter("order_id")[0];

		int int_order_id = Integer.parseInt(order_id);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        OrderHistoryDao order = factory.getOrderHistoryDao();
        ConnectionManager cm = factory.getConnectionManager();
        OrderHistoryList orderHistoryList = new OrderHistoryList();

        cm.beginTransaction();

        try {

        	orderHistoryList = order.getOrderHistoryList(int_order_id);

            resc.setResult(orderHistoryList);
            resc.setTarget("displayOrderHistory");

        }catch(DisplayOrderHistoryFailedException e) {

	        Message message=new Message();
	        message.setMessage("注文履歴が表示できません。");
	        e.printStackTrace();

        }
        cm.commit();
        cm.closeConnection();

        return resc;
	}


}