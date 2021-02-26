package command;

import java.util.Map;

import bean.Message;
import bean.Product;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaDao;
import dao.SideDao;
import utility.ImageNavigation;

public class AddSideCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();


        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        PizzaDao pd = factory.getPizzaDao();
        SideDao dao=factory.getSideDao();

        Message message=new Message();
        Product product_id = null;

        cm.beginTransaction();


        		product_id = dao.getSideId("","");
        		ImageNavigation in = new ImageNavigation();
        		Map map=in.imageNavi(product_id.getProduct_id(),reqc);
        		String products_name = (String)map.get("name");
        		String products_explanation = (String)map.get("explanation");
        		String price = (String)map.get("price");

        		//String products_display = reqc.getParameter("display")[0];
        		String products_category = (String)map.get("category");


        		int products_price = Integer.parseInt(price);

        		Product product = new Product();
        		product.setName(products_name);
        		product.setExplanation(products_explanation);
        		product.setPrice(products_price);
//        		product.setProductstype(type);

        		product.setProduct_category(products_category);
        		dao.addSide(product);
            	message.setMessage("side登録完了");

            	dao.updateSideImage(product_id.getProduct_id());



        resc.setTarget("addProductsResult");

        cm.commit();

        cm.closeConnection();

        resc.setResult(message);


		return resc;

	}

}
