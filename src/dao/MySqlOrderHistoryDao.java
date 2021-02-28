//2.28 浅倉
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.OrderHistory;
import bean.OrderHistoryList;
import exception.IntegrationException;

public class MySqlOrderHistoryDao implements OrderHistoryDao {

	@Override
	public OrderHistoryList getOrderHistoryList(int order_id) {
		Connection cn = MySqlConnectionManager.getInstance().getConnection();
	    PreparedStatement st = null;
	    ResultSet rs=null;
	    OrderHistoryList orderHistoryList = new OrderHistoryList();
	    ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();

	    try {
	    	String sql = "select order_date,order_id, orderdetail_id, custom_id, product_amount, order_delivery," +
	    				"IFNULL(pizza_id,IFNULL(pizzaoption_id,side_id)) AS product_id," +
	    				"IFNULL(pizza_price,IFNULL(pizzaoption_price,side_price)) AS product_price," +
	    				"IFNULL(pizza_name,IFNULL(pizzaoption_name,side_name)) AS product_name " +
	    				"FROM ORDER_TABLE " +
	    				"RIGHT JOIN ORDERDETAIL_TABLE USING(order_id) " +
	    				"LEFT JOIN PIZZA_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZA_TABLE.pizza_id " +
	    				"LEFT JOIN PIZZAOPTION_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZAOPTION_TABLE.pizzaoption_id " +
	    				"LEFT JOIN SIDE_TABLE ON ORDERDETAIL_TABLE.product_id = SIDE_TABLE.side_id " +
	    				"WHERE order_id = ?;";

	    	st=cn.prepareStatement(sql);

	    	st.setInt(1, order_id);

	    	rs = st.executeQuery();

	    	while(rs.next()) {
	    		OrderHistory orderHistory = new OrderHistory();

	    		orderHistory.setOrder_date(rs.getString(1));
	    		orderHistory.setOrder_id(rs.getInt(2));
	    		orderHistory.setOrderdetail_id(rs.getInt(3));
	    		orderHistory.setCustom_id(rs.getInt(4));
	    		orderHistory.setProduct_amount(rs.getInt(5));
	    		orderHistory.setOrder_delivery(rs.getBoolean(6));
	    		orderHistory.setProduct_id(rs.getInt(7));
	    		orderHistory.setProduct_price(rs.getInt(8));
	    		orderHistory.setProduct_name(rs.getString(9));

	    		list.add(orderHistory);
	    	}
	    	orderHistoryList.setOrderHistoryList(list);

	    }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
	    }
	return orderHistoryList;
	}

}
