package command;

import bean.Order;
import bean.OrderDetail;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.OrderDao;
import dao.OrderDetailDao;

public class AddOrderDetailCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {

		RequestContext reqc = getRequestContext();

		String users_number = reqc.getParameter("user_number")[0];
		int user_number =  Integer.parseInt(users_number);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();
		OrderDetailDao odd = factory.getOrderDetailDao();
		OrderDao odao = factory.getOrderDao();
		OrderDetail detail = new OrderDetail();

		cm.beginTransaction();

		odao.addOrder(user_number);

		Order order_id = odao.getOrderId(user_number);

		int id =reqc.getParameter("custom_id").length;

		for(int i=0;i<id;i++){
		    String custom_ids = reqc.getParameter("custom_id")[i];
		    String product_ids = reqc.getParameter("product_id")[i];
		    String product_amounts = reqc.getParameter("product_amount")[i];

		    int custom_id =  Integer.parseInt(custom_ids);
		    int product_id =  Integer.parseInt(product_ids);
		    int product_amount =  Integer.parseInt(product_amounts);

		    detail.setCustom_id(custom_id);
		    detail.setProduct_id(product_id );
		    detail.setProduct_amount(product_amount);

		    odd.addOrderDetail(detail,order_id);

		}

		cm.commit();

        cm.closeConnection();

        //responseContext.setResult(message);

        return responseContext;
	}

}
