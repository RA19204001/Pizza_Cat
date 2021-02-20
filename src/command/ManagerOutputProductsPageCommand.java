package command;

import java.util.ArrayList;

import bean.Message;
import bean.Products;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.MySqlPizzaDao;
import dao.MySqlPizzaOptionDao;
import dao.MySqlSideDao;
import exception.PizzaViewFailedException;

public class ManagerOutputProductsPageCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext responseContext) {

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

			ArrayList hidePizzaList = dao.getHidePizza();

			ArrayList hideOptionlist = myOptionDao.getHidePizzaOption();

			ArrayList hideSideList = sideDao.getHideSide();

			Products ps = new Products();

			ps.setList(arrayList);
			ps.setOptionList(optionlist);
			ps.setSideList(sideList);
			ps.setHidepizzaList(hidePizzaList);
			ps.setHideoptionList(hideOptionlist);
			ps.setHidesideList(hideSideList);

			responseContext.setResult(ps);
			responseContext.setTarget("editDisplay");

		}catch(PizzaViewFailedException e) {

			Message message=new Message();
			message.setMessage("ピザメニューを表示できません");
			e.printStackTrace();

		}

		cm.commit();
		cm.closeConnection();

		return responseContext;


	}
}
