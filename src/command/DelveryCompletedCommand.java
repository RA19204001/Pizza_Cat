package command;

import bean.AddresseeList;
import bean.Order;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.DeliveryDao;
import dao.OrderDao;
import exception.IntegrationException;

public class DelveryCompletedCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		// TODO 自動生成されたメソッド・スタブ
		RequestContext reqc = getRequestContext();

		String order_id=reqc.getParameter("order_id")[0];

		Order order=new Order();
		order.setOrder_id(Integer.parseInt(order_id));
		order.setOrder_delivery(true);

		AddresseeList address=new AddresseeList();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();
		OrderDao orderdao= factory.getOrderDao();
		DeliveryDao deld = factory.getDeliveryDao();

		cm.beginTransaction();

		try {
			orderdao.updateDelivery(order);
			address=deld.getAddresseeList();
			resc.setResult(address);
            resc.setTarget("addressee");


		}catch(IntegrationException e) {
			e.printStackTrace();
		}
		cm.commit();

        cm.closeConnection();
		return resc;
	}

}
