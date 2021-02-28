//2/16
package bean;

public class Order implements Bean {

	private int order_id;
	private String order_date;
	private int user_number;
	private boolean Order_delivery;
	private String order_payment;
	public Order() {}

	public String getOrder_payment() {
		return order_payment;
	}
	public void setOrder_payment(String order_payment) {
		this.order_payment = order_payment;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getUser_number() {
		return user_number;
	}
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public boolean getOrder_delivery() {
		return Order_delivery;
	}
	public void setOrder_delivery(boolean order_delivery) {
		Order_delivery = order_delivery;
	}

}
