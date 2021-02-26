package bean;

import java.util.ArrayList;

public class OrderHistoryList implements Bean {

	private ArrayList<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();

	public OrderHistoryList() {}

	public ArrayList<OrderHistory> getOrderHistoryList(){
		return orderHistoryList;
	}

	public void setOrderHistoryList(ArrayList<OrderHistory> orderHistoryList) {
		this.orderHistoryList = orderHistoryList;
	}
}
