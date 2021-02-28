//0221染谷
//2.28 浅倉
package dao;

public class MySqlDaoFactory extends AbstractDaoFactory{

  public UserDao getUserDao(){
    return new MySqlUserDao();
  }
  public CardDao getCardDao(){
	    return new MySqlCardDao();
	}
  public PizzaDao getPizzaDao() {
	  return new MySqlPizzaDao();
  }

  public PizzaOptionDao getPizzaOptionDao() {
	  return new MySqlPizzaOptionDao();
  }

  public SideDao getSideDao() {
	  return new MySqlSideDao();
  }
  public ConnectionManager getConnectionManager() {
	  return MySqlConnectionManager.getInstance();
  }
  public OrderDetailDao getOrderDetailDao() {
	  return new MySqlOrderDetailDao();
  }
  public OrderDao getOrderDao() {
	  return new MySqlOrderDao();
  }
  public SalesDao getSalesDao() {
	  return new MySqlSalesDao();
  }
  public DeliveryDao getDeliveryDao() {
	  return new MySqlDeliveryDao();
  }
	public OrderHistoryDao getOrderHistoryDao() {
		return new MySqlOrderHistoryDao();
	}
}
