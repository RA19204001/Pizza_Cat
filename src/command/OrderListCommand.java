package command;


import bean.Message;
import bean.OrderHistoryList;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.OrderDao;
import exception.DisplayOrderHistoryFailedException;

public class OrderListCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();
		String user_number = reqc.getParameter("user_number")[0];

		 AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
	     OrderDao od = factory.getOrderDao();
	     ConnectionManager cm = factory.getConnectionManager();
	     OrderHistoryList orderHistoryList = new OrderHistoryList();
	     cm.beginTransaction();

	        try {
	        	orderHistoryList = od.getOrderHistoryList(Integer.parseInt(user_number));
	        }catch(DisplayOrderHistoryFailedException e) {
	        	Message message=new Message();
	            message.setMessage("オーダー一覧を表示できません");
	            e.printStackTrace();

	        }
		return null;
	}

}
