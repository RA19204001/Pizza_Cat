//いががががぎご


package command;

import bean.Message;
import bean.Product;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.PizzaDao;
import dao.PizzaOptionDao;
import dao.SideDao;
import exception.IntegrationException;

public class EditDisplayCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String id = reqc.getParameter("id")[0];
		String display = reqc.getParameter("display")[0];

		int product_id = Integer.parseInt(id);
		int product_display = Integer.parseInt(display);

		Product product = new Product();
		product.setProduct_id(id);

        if(product_display == 1) {
            product.setProduct_display(true);
        }else {

            product.setProduct_display(false);
        }

        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        ConnectionManager cm = factory.getConnectionManager();

        PizzaDao pd = factory.getPizzaDao();
        PizzaOptionDao pod = factory.getPizzaOptionDao();
        SideDao sd = factory.getSideDao();
        Message message=new Message();
        cm.beginTransaction();


        if(product_id <= 10000) {
        	try {
        		pd.editDisplayPizza(id, product);
        		message.setMessage("pizza削除完了");
        	}catch(IntegrationException e) {
        		cm.rollback();
                message.setMessage("ピザの表示変更しっぱぁ～い！");
                e.printStackTrace();
        	}
        }else if(10001 <= product_id || product_id <= 20000) {

        	try {
        		pod.editDisplayPizzaOption(id, product);
        		message.setMessage("pizzaoption削除完了");
        	}catch(IntegrationException e) {
        		cm.rollback();
                message.setMessage("オプションの表示変更しっぱぁ～い！");
                e.printStackTrace();
        	}
        }else {
        	try {
        		sd.editDisplaySide(id, product);
        		message.setMessage("side削除完了");
        	}catch(IntegrationException e) {
        		cm.rollback();
                message.setMessage("サイドメニューの表示変更しっぱぁ～い！");
                e.printStackTrace();
        	}
        }


        resc.setTarget("editProductsResult");

        cm.commit();

        cm.closeConnection();

        resc.setResult(message);
		return resc;
	}

}
