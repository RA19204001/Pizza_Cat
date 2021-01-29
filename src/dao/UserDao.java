package dao;

//10.29 移行 大川
// 1.29変更 内田
import bean.User;

public interface UserDao {
	public void addUser(bean.User u);
	public User getUser(String id, String pass);
	public boolean isUniqueUserId(String id);
	public User authenticateUser(String id, String pass);
	public void editUser(String id, User user);
	public void addCardId(String id,String card_id);
}
