//浅倉 2/17
//浅倉 2/18
package command;

import java.util.ArrayList;

import bean.Cart;
import bean.Message;
import bean.Products;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.MySqlPizzaDao;
import dao.MySqlPizzaOptionDao;
import dao.MySqlSideDao;
import exception.PizzaViewFailedException;


public class AddCartCommand extends AbstractCommand {

	private ArrayList array = new ArrayList();
	private ArrayList optionList = new ArrayList();
	private Products pros = new Products();

	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();

		String name = reqc.getParameter("name")[0];
		String price = reqc.getParameter("price")[0];
		String id = reqc.getParameter("id")[0];
		String amount = reqc.getParameter("amount")[0];

		int prices =  Integer.parseInt(price);
		int amounts =  Integer.parseInt(amount);
		int flagid=Integer.parseInt(id);




		if(reqc.getParameter("cart_name") != null){
			for(int i=0 ;i<reqc.getParameter("cart_name").length;i++) {
				String cartname=reqc.getParameter("cart_name")[i];
				String cartprice=reqc.getParameter("cart_price")[i];
				String cartid=reqc.getParameter("cart_id")[i];
				String cartamount=reqc.getParameter("cart_amount")[i];
				String cartcustamid=reqc.getParameter("cart_custamid")[i];

				int cartprices=Integer.parseInt(cartprice);
				int cartamounts=Integer.parseInt(cartamount);
				int cartcustamids=Integer.parseInt(cartcustamid);
				Cart newcart=new Cart();

				newcart.setAmount(cartamounts);
				newcart.setPrice(cartprices);
				newcart.setId(cartid);
				newcart.setName(cartname);
				newcart.setCustamid(cartcustamids);

				array.add(newcart);

			}
		}
		Cart cart = new Cart();


		cart.setName(name);
		cart.setPrice(prices);
		cart.setId(id);
		cart.setAmount(amounts);

		if(array.size()!=0) {
			Cart oldcart=(Cart)array.get(array.size()-1);
			cart.setCustamid(oldcart.getCustamid()+1);
		}else {
			cart.setCustamid(1);
		}
		array.add(cart);

		if(flagid<30000) {
			for(int i = 0;i < reqc.getParameter("option").length;i++) {
				String option = reqc.getParameter("option")[i];
				optionList.add(option);
				int op1 = option.indexOf(":");
				int op2 = option.indexOf(":",op1+1);
				int op3 = option.indexOf(":",op2+1);
				String optionname = option.substring(0,op1);
				String optionamount = option.substring(op1+1,op2);
				String optionprice = option.substring(op2+1,op3);
				String optionproduct_id = option.substring(op3+1);
				if(!(optionamount.equals("0"))) {
					Cart optioncart = new Cart();

					int optionprices =  Integer.parseInt(optionprice);
					int optionamounts =  Integer.parseInt(optionamount);

					optioncart.setName(optionname);
					optioncart.setPrice(optionprices*optionamounts);
					optioncart.setId(optionproduct_id);
					optioncart.setAmount(optionamounts);
					if(array.size()!=0) {
						Cart oldcart=(Cart)array.get(array.size()-1);
						optioncart.setCustamid(oldcart.getCustamid());
					}else {
						optioncart.setCustamid(1);
					}
					array.add(optioncart);
				}
			}
		}
		pros.setAddList(array);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();

		cm.beginTransaction();

		try {

			MySqlPizzaDao dao = new MySqlPizzaDao();

			MySqlPizzaOptionDao myOptionDao = new  MySqlPizzaOptionDao();

			MySqlSideDao sideDao = new MySqlSideDao();

			ArrayList arrayList = dao.getPizza();

			ArrayList optionlist = myOptionDao.getPizzaOption();

			ArrayList sideList = sideDao.getSide();

			pros.setList(arrayList);
			pros.setOptionList(optionlist);
			pros.setSideList(sideList);

			resc.setResult(pros);
			resc.setTarget("menu");

		}catch(PizzaViewFailedException e) {

			Message message=new Message();
			message.setMessage("ピザメニューを表示できません");
			e.printStackTrace();

		}

		cm.commit();
		cm.closeConnection();



		return resc;
	}


}
