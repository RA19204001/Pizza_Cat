//2/17 大川
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;
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
		String sql = "UPDATE order_table set order_delivery = ? WHERE order_id = ?";
		st=cn.prepareStatement(sql);

		st.setBoolean(1, order.getOrder_delivery());
		st.setInt(2, order.getOrder_id());

		rs = st.executeQuery();
		rs.next();

	}catch(SQLException e){
        e.printStackTrace();
        throw new IntegrationException(e.getMessage(),e);
	}
	}

}
