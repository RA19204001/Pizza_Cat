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

	public void addOrder(int user_number,String order_payment) {

		try{
			//sysdateがnowかもしれない
            String sql = "insert into ORDER_TABLE(order_date, user_number,order_payment)"+"value(CURDATE(),?,?)";

            st = cn.prepareStatement(sql);

            //st.setString(1,order_date);
            st.setInt(1,user_number);
            st.setString(2,order_payment);
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


	public OrderHistoryList getOrderDate(int user_number){
        OrderHistoryList ohlist = new OrderHistoryList();
        ArrayList list = new ArrayList();

        try {
            String sql = "select order_date,order_id,order_payment from ORDER_TABLE where user_number = ? order by order_id desc";
            st=cn.prepareStatement(sql);

            st.setInt(1,user_number);

            rs = st.executeQuery();
            while(rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setOrder_date(rs.getString(1));
                orderHistory.setOrder_id(rs.getInt(2));
                orderHistory.setOrder_payment(rs.getString(3));
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
