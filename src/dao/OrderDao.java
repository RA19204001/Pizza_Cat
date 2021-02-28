//2.16 大川
package dao;

import bean.Order;
import bean.OrderHistoryList;

public interface OrderDao {
	public void addOrder(int user_number,String order_payment);
	public Order getOrderId(int user_number);
	public void updateDelivery(Order order);
	public OrderHistoryList getOrderDate(int user_number);
}
