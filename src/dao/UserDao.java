package dao;

import bean.Card;
// 1.29 移行 大川
// 1.29変更 内田
// 2.4 追加 大川
// 2.27 浅倉
import bean.User;

public interface UserDao {
	public void addUser(bean.User u);
	public User getUser(String id, String pass);
	public boolean isUniqueUserId(String id);
	public User authenticateUser(String id, String pass);
	public void editUser(String id, User user);
	public void addCardId(String id,Card card_id);
	public User getUser(String id);
}
