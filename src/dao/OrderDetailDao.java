//2.16
package dao;

import java.util.ArrayList;

import bean.Order;
import bean.OrderDetail;

public interface OrderDetailDao {

	public void addOrderDetail(OrderDetail od,Order order_id);
	public ArrayList getOrderDetail(int order_id);

}
