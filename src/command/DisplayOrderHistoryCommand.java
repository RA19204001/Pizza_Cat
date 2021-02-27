package command;


import bean.Message;
import bean.OrderHistoryList;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.OrderDao;
import exception.DisplayOrderHistoryFailedException;

public class DisplayOrderHistoryCommand extends AbstractCommand {

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

        try {

        	orderHistoryList = order.getOrderHistoryList(int_user_number);

            resc.setResult(orderHistoryList);
            resc.setTarget("orderHistory");

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