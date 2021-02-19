//2.16  大川
package command;

import java.util.ArrayList;

import bean.Cart;
import bean.Order;
import bean.OrderDetail;
import bean.Receipt;
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

		Order order_id = null;

		//try {
			order_id = odao.getOrderId(user_number);
			int id =reqc.getParameter("id").length;

			String product_ids;
			String product_amounts;
			int custom_id = 0;

			ArrayList orderlist =new ArrayList();
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

			    String rename = reqc.getParameter("name")[i];
			    String reprice = reqc.getParameter("price")[i];
			    String reamount = reqc.getParameter("amount")[i];

			    int reprices=Integer.parseInt(reprice);
			    int reamounts=Integer.parseInt(reamount);
			    Cart cart = new Cart();
			    cart.setName(rename);
			    cart.setPrice(reprices);
			    cart.setAmount(reamounts);

			    orderlist.add(cart);

			}

			String retotal=reqc.getParameter("total")[0];
			Receipt receipt = new Receipt();
			receipt.setList(orderlist);
			receipt.setTotal(retotal);
	        //必要なら
	        responseContext.setResult(receipt);

	        //確認画面へ？
	        responseContext.setTarget("pay");

			cm.commit();
	        cm.closeConnection();

		//}
		//catch(NullPointerException e){
			//responseContext.setTarget("menu");

		//}
			return responseContext;
	}
}
