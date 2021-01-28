package dao;

public class MySqlDaoFactory extends AbstractDaoFactory {

	  public UserDao getUserDao(){
	    return new MySqlUserDao();
	  }

	  public ConnectionManager getConnectionManager() {
		  return MySqlConnectionManager.getInstance();
	  }

}
