package command;

import java.util.Map;

import bean.Message;
import bean.Product;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaDao;
import utility.ImageNavigation;

public class AddProductsCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {


		RequestContext reqc = getRequestContext();


        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        PizzaDao pd = factory.getPizzaDao();

        Message message=new Message();
        Product product_id = null;

        cm.beginTransaction();


        		product_id = pd.getPizzaId("","");
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
        		pd.addPizza(product);
            	message.setMessage("pizza登録完了");

            	pd.updatePizzaImage(product_id.getProduct_id());




        cm.commit();

        cm.closeConnection();

        responseContext.setTarget("addProductsResult");
        responseContext.setResult(message);


		return responseContext;
	}

	private String judgeParameter(RequestContext reqc) {

		String products_image = "";
		try {
		products_image = reqc.getParameter("file")[0];

    	}catch(NullPointerException e){
    		e.printStackTrace();
    	}finally {
    		return products_image;
    	}
	}
}
