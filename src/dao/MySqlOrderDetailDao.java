//2/16
//2,17 大川
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Order;
import bean.OrderDetail;
import exception.IntegrationException;

public class MySqlOrderDetailDao implements OrderDetailDao {

	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;

	public void addOrderDetail(OrderDetail od,Order order_id) {

		try{

            String sql = "insert into ORDERDETAIL_TABLE(order_id, custom_id, product_id, product_amount)"+"value(?,?,?,?)";

            st = cn.prepareStatement(sql);

            st.setInt(1,order_id.getOrder_id());
            st.setInt(2,od.getCustom_id());
            st.setInt(3,od.getProduct_id());
            st.setInt(4,od.getProduct_amount());

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);

	    }
	}

	public ArrayList getOrderDetail(Order order_id) {

		ArrayList list = new ArrayList();
	    try {
	    	String sql = "select custom_id,product_id,product_amount from ORDERDETAIL_TABLE where order_id = ?";

	    	st=cn.prepareStatement(sql);

	    	st.setInt(1,order_id.getOrder_id());

    		rs = st.executeQuery();
    		while(rs.next()) {
    			OrderDetail o = new OrderDetail();

    			o.setCustom_id(rs.getInt(1));
    			o.setProduct_amount(rs.getInt(2));
    			o.setProduct_id(rs.getInt(3));

    			list.add(o);

    		}

	    }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);

	    }
	    return list;
	}

}
