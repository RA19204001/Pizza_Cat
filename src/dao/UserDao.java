package dao;

//10.29 移行 大川
import bean.User;

public interface UserDao {
	public void addUser(bean.User u);
	public User getUser(String id, String pass);
	public boolean isUniqueUserId(String id);
	public User authenticateUser(String id, String pass);
	public User editUser(String id, User user);
	public void addCardId(String id,String card_id);
}
