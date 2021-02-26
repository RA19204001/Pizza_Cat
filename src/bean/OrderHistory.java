package bean;

public class OrderHistory implements Bean {
	private String order_date;
	private int order_id;
	private int orderdetail_id;
	private int custom_id;
	private int product_id;
	private String product_name;
	private int product_price;
	private int product_amount;
	private boolean Order_delivery;

	public OrderHistory() {}


	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}


	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getOrderdetail_id() {
		return orderdetail_id;
	}
	public void setOrderdetail_id(int orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}


	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(int custom_id) {
		this.custom_id = custom_id;
	}


	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}


	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}


	public boolean isOrder_delivery() {
		return Order_delivery;
	}
	public void setOrder_delivery(boolean order_delivery) {
		Order_delivery = order_delivery;
	}

}
