package command;

import java.util.ArrayList;

import bean.Message;
import bean.Products;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaDao;
import dao.PizzaOptionDao;
import dao.SideDao;
import exception.PizzaViewFailedException;

public class ManagerOutputProductsPageCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext responseContext) {

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();
		PizzaDao pdao = factory.getPizzaDao();
		PizzaOptionDao opdao = factory.getPizzaOptionDao();
		SideDao sdao = factory.getSideDao();

		cm.beginTransaction();

		try {

			ArrayList arrayList = pdao.getPizza();

			ArrayList optionlist = opdao.getPizzaOption();

			ArrayList sideList = sdao.getSide();

			ArrayList hidePizzaList = pdao.getHidePizza();

			ArrayList hideOptionlist = opdao.getHidePizzaOption();

			ArrayList hideSideList = sdao.getHideSide();

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
