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
}
