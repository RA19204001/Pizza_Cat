package bean;

//10.29 移行 大川
public class Card implements Bean {
	//private String card_id;
	private String creditnumber;
	private String security_code;
	private String expiration_date;
	private String mail_address;

	//-------------------------------------------------Creditnumber
	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}
	//-------------------------------------------------Security_code
	public String getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
	//-------------------------------------------------Exception_date
	public String getException_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	//-------------------------------------------------Mail_address
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
}
