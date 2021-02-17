//2.16  大川
package command;

import bean.Message;
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

		Message message=new Message();
		//失敗することがない?
        //message.setMessage("購入完了");


		Order order_id = odao.getOrderId(user_number);

		int id =reqc.getParameter("id").length;

		String product_ids;
		String product_amounts;
		int custom_id = 0;

		for(int i=0;i<id;i++){
			product_ids = reqc.getParameter("id")[i];
			product_amounts = reqc.getParameter("amount")[i];

			int product_id =  Integer.parseInt(product_ids);
			int product_amount =  Integer.parseInt(product_amounts);
		    if(product_id >= 19999 || product_id <=10000) {
		    	custom_id +=1;

		    }


		    detail.setCustom_id(custom_id);
		    detail.setProduct_id(product_id );
		    detail.setProduct_amount(product_amount);

		    odd.addOrderDetail(detail,order_id);

		}


        //確認画面へ？
        responseContext.setTarget("pay");

		cm.commit();

        cm.closeConnection();

        //必要なら
        //responseContext.setResult(message);

        return responseContext;
	}

}
