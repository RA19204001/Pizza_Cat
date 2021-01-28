package dao;

import bean.User;

public interface UserDao {
	public void addUser(bean.User u);
	public User getUser(String id, String pass);
	public boolean isUniqueUserId(String id);
	public User authenticateUser(String id, String pass);
	public User editUser(String id, User user);
}
