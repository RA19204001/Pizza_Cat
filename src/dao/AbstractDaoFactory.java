//1/29 いが
//0221染谷

package dao;

import java.util.Properties;
import java.util.ResourceBundle;

public abstract class AbstractDaoFactory {

	public static AbstractDaoFactory getFactory(){

		    AbstractDaoFactory factory = null;
		    Properties prop = new Properties();
		    ResourceBundle resorce=null;

		    try{
		    	resorce=ResourceBundle.getBundle("property\\dao");
		        String name=resorce.getString("dao");

		      Class c = Class.forName(name);

		      factory = (AbstractDaoFactory)c.newInstance();


		    }catch (ClassNotFoundException e) {
		      e.printStackTrace();
			} catch (InstantiationException e) {
		     e.printStackTrace();
			} catch (IllegalAccessException e) {
		      e.printStackTrace();
				}

		    return factory;

		  }
		  public abstract UserDao getUserDao();
		  public abstract PizzaDao getPizzaDao();
		  public abstract PizzaOptionDao getPizzaOptionDao();
		  public abstract SideDao getSideDao();
		  public abstract CardDao getCardDao();
		  public abstract ConnectionManager getConnectionManager();
		  public abstract OrderDetailDao getOrderDetailDao();
		  public abstract OrderDao getOrderDao();
		  public abstract SalesDao getSalesDao();
		  public abstract DeliveryDao getDeliveryDao();
		  public abstract OrderHistoryDao getOrderHistoryDao();
}
