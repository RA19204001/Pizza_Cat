/*
 * 作成日： 2021/02/02 14:20
 * 作成者： 内田 悠貴
 * <クラス概要説明>
 * DAO使ってJSPに商品情報を渡す
 *
 */
package command;

import java.util.ArrayList;

import bean.Message;
import bean.Products;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.MySqlPizzaDao;
import exception.PizzaViewFailedException;

public class OutputProductsPageCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext responseContext) {

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager cm = factory.getConnectionManager();

		cm.beginTransaction();

		try {

			MySqlPizzaDao dao = new MySqlPizzaDao();

			ArrayList arrayList = dao.getPizza();

			Products ps = new Products();

			ps.setList(arrayList);

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
