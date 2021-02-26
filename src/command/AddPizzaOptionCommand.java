package command;

import bean.Message;
import bean.Product;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaOptionDao;

public class AddPizzaOptionCommand extends AbstractCommand {


	public ResponseContext execute(ResponseContext responseContext) {

	RequestContext reqc = getRequestContext();

	String products_name = reqc.getParameter("name")[0];
    String products_explanation = reqc.getParameter("explanation")[0];
    String price = reqc.getParameter("price")[0];
    String type = reqc.getParameter("type")[0];
    String products_category = reqc.getParameter("category")[0];


    int products_price = Integer.parseInt(price);

    Product product = new Product();
    product.setName(products_name);
    product.setExplanation(products_explanation);
    product.setPrice(products_price);
    product.setProductstype(type);
    product.setProduct_category(products_category);

    AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
    ConnectionManager cm = factory.getConnectionManager();
    PizzaOptionDao pod = factory.getPizzaOptionDao();
    Message message=new Message();

    cm.beginTransaction();

    pod.addPizzaOption(product);
	message.setMessage("option登録完了");

    responseContext.setTarget("addProductsResult");

    cm.commit();

    cm.closeConnection();

    responseContext.setResult(message);


	return responseContext;
	}
}
