// 2.5 大川
package bean;

public class Manager implements Bean {
	private String id;
	private String pass;
	private String token;

	//--------------------------------- id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//---------------------------------- pass
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	//---------------------------------- token
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
