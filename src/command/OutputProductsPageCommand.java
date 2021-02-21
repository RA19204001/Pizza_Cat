/*
 * 作成日： 2021/02/02 14:20
 * 作成者： 内田  悠貴
 * <クラス概要説明>
 * DAO使ってJSPに商品情報を渡す
 * 浅倉 2/3
 * 浅倉 2/18
 */
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

public class OutputProductsPageCommand extends AbstractCommand {

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

			Products ps = new Products();

			ps.setList(arrayList);
			ps.setOptionList(optionlist);
			ps.setSideList(sideList);

			responseContext.setResult(ps);
			responseContext.setTarget("menu");

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
