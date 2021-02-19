/*
2021/02/18 内田

*/

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

public class DeleteCartCommand extends AbstractCommand {

	private ArrayList array = new ArrayList();
	private ArrayList optionList = new ArrayList();
	private ArrayList sideList = new ArrayList();
	private Products pros = new Products();

	@Override
	public ResponseContext execute(ResponseContext resc) {
		// cart内の商品を削除する処理
		RequestContext reqc = getRequestContext();


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

		// 削除指定されたデータ
		String delete_id = reqc.getParameter("delete_id")[0];// 商品番号
		String delete_custam_id=reqc.getParameter("delete_custam_id")[0];

		for (int i = 0; i < array.size(); i++) {

			Cart newcart = (Cart)array.get(i);
			int custamid = newcart.getCustamid();
			String id=newcart.getId();
			int ids=Integer.parseInt(id);
			int delete_ids=Integer.parseInt(delete_id);
			int delete_custam_ids=Integer.parseInt(delete_custam_id);

			if (ids==delete_ids) {
				if(ids<=10000) {

						for(int j=0;j<array.size();j++) {

							Cart deleteproduct=(Cart)array.get(j);
							int deletecustamid=deleteproduct.getCustamid();
							System.out.println(deletecustamid+";"+custamid);
							if(custamid==deletecustamid) {
								array.remove(j);
								j--;
							}
						}

					}else if(custamid==delete_custam_ids){
						array.remove(i);
					}
				}

			}

		//後半
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
