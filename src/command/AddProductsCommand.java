package command;

//2/10 大川
//2/12 大川
import java.io.File;

import bean.Message;
import bean.Product;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaDao;
import dao.PizzaOptionDao;
import dao.SideDao;
import utility.ImageNavigation;

public class AddProductsCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext responseContext) {


		RequestContext reqc = getRequestContext();

		String products_name = reqc.getParameter("name")[0];
        String products_explanation = reqc.getParameter("explanation")[0];
        String price = reqc.getParameter("price")[0];
        String type = reqc.getParameter("type")[0];
        //String products_display = reqc.getParameter("display")[0];
        String products_category = reqc.getParameter("category")[0];


        int products_price = Integer.parseInt(price);

        Product product = new Product();
        product.setName(products_name);
        product.setExplanation(products_explanation);
        product.setPrice(products_price);
        product.setProductstype(type);
        String image_name = new File(judgeParameter(reqc)).getName();
        //product.setImage(judgeParameter(reqc));
        product.setImage(image_name);
        //product.setProduct_display(products_display);
        product.setProduct_category(products_category);

        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();
        PizzaDao pd = factory.getPizzaDao();
        PizzaOptionDao pod = factory.getPizzaOptionDao();
        SideDao sd = factory.getSideDao();
        Message message=new Message();
        Product product_id = null;

        cm.beginTransaction();

        //pizzaのoptionの時
        if(type.equals("2")) {
        	pod.addPizzaOption(product);
        	message.setMessage("option登録完了");
        }else {

        	//pizzaの時
        	if(type.equals("1")) {
        		pd.addPizza(product);
            	message.setMessage("pizza登録完了");
            	product_id = pd.getPizzaId(products_name,products_explanation);

            	pd.updatePizzaImage(image_name);
            //sideメニューの時
        	}else{
        		sd.addSide(product);
            	message.setMessage("side登録完了");
            	product_id = sd.getSideId(products_name,products_explanation);

               	sd.updateSideImage(image_name);
        	}
        	 ImageNavigation in = new ImageNavigation();
 	        in.imageNavi(judgeParameter(reqc),product_id.getProduct_id());
        }


        responseContext.setTarget("addProductsResult");

        cm.commit();

        cm.closeConnection();

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
