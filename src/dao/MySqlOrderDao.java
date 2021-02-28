//2/17 大川
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Order;
import bean.OrderHistory;
import bean.OrderHistoryList;
import exception.IntegrationException;

public class MySqlOrderDao implements OrderDao {

	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;

	public void addOrder(int user_number) {

		try{
			//sysdateがnowかもしれない
            String sql = "insert into ORDER_TABLE(order_date, user_number)"+"value(CURDATE(),?)";

            st = cn.prepareStatement(sql);

            //st.setString(1,order_date);
            st.setInt(1,user_number);
            //st.setInt(sysdate);

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);

	    }

	}
	public Order getOrderId(int user_number) {
		Order order = new Order();
		try {
			String sql = "select order_id from ORDER_TABLE where order_date = CURDATE() AND user_number = ? order by order_id desc";

			st=cn.prepareStatement(sql);

    		st.setInt(1,user_number);

    		rs = st.executeQuery();
    		rs.next();
    		order.setOrder_id(rs.getInt(1));

		}catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
    	}
		return order;
	}

	public void updateDelivery(Order order) {
		try {
			String sql = "UPDATE ORDER_TABLE set order_delivery = ? WHERE order_id = ?";
			st=cn.prepareStatement(sql);

			st.setBoolean(1, order.getOrder_delivery());
			st.setInt(2, order.getOrder_id());

			st.executeUpdate();


		}catch(SQLException e){
			e.printStackTrace();
			throw new IntegrationException(e.getMessage(),e);
		}
	}

	public OrderHistoryList getOrderHistoryList(int user_number) {
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
	    				"WHERE user_number = ?" +
	    				"ORDER BY order_id DESC;";

	    	st=cn.prepareStatement(sql);

	    	st.setInt(1, user_number);

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
	public OrderHistoryList getOrderDate(int user_number){
        OrderHistoryList ohlist = new OrderHistoryList();
        ArrayList list = new ArrayList();

        try {
            String sql = "select order_date,order_id from ORDER_TABLE where user_number = ? order by order_id desc";
            st=cn.prepareStatement(sql);

            st.setInt(1,user_number);

            rs = st.executeQuery();
            while(rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setOrder_date(rs.getString(1));
                orderHistory.setOrder_id(rs.getInt(2));
                list.add(orderHistory);
            }
            ohlist.setOrderHistoryList(list);

        }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
        }
        return ohlist;
    }

}
