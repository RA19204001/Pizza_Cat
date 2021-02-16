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
            String sql = "insert into ORDER_TABLE(order_date, user_number)"+"value(sysdate,?)";

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
			String sql = "select order_id from ORDER_TABLE where order_date = sysdate AND user_number = ?";

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

}
