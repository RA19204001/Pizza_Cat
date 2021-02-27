package bean;

import java.util.ArrayList;

//10.29 移行 大川
//2.16 手直し
public class Card implements Bean {
	private String card_id;
	private String creditnumber;
	private String security_code;
	private String expiration_date;
	private String mail_address;
	private ArrayList cardInfo;

	public Card() {}
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
	public String getExpiration_date() {
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
	//-------------------------------------------------card_id
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	//-------------------------------------------------cardIndo
	public ArrayList getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(ArrayList cardInfo) {
		this.cardInfo = cardInfo;
	}
}
