//浅倉 2/17
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
		for(int i = 0;i < reqc.getParameter("option").length;i++) {
			String option = reqc.getParameter("option")[i];
			optionList.add(option);
		}
		int prices =  Integer.parseInt(price);
		int amounts =  Integer.parseInt(amount);

		Cart cart = new Cart();
		cart.setName(name);
		cart.setPrice(prices);
		cart.setId(id);
		cart.setAmount(amounts);
		cart.setOption(optionList);

		array.add(cart);
		pros.setAddList(array);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();

		cm.beginTransaction();

		try {

			MySqlPizzaDao dao = new MySqlPizzaDao();

			MySqlPizzaOptionDao myOptionDao = new  MySqlPizzaOptionDao();

			ArrayList arrayList = dao.getPizza();

			ArrayList optionlist = myOptionDao.getPizzaOption();

			pros.setList(arrayList);
			pros.setOptionList(optionlist);

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
