package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Addressee;
import bean.AddresseeList;
import exception.IntegrationException;


public class MySqlDeliveryDao implements DeliveryDao{

	public AddresseeList getAddresseeList() {

		Connection cn = MySqlConnectionManager.getInstance().getConnection();
	    PreparedStatement st = null;
	    ResultSet rs=null;
	    AddresseeList al = new AddresseeList();
	    ArrayList<Addressee> list = new ArrayList<Addressee>();

	    try {
	    	String sql = "select order_date,order_id, orderdetail_id, user_number, user_name, user_address, custom_id, product_amount,order_delivery," +
	    						" IFNULL(pizza_id,IFNULL(pizzaoption_id,side_id)) AS product_id," +
	    						" IFNULL(pizza_name,IFNULL(pizzaoption_name,side_name)) AS product_name" +
	    					" FROM ORDER_table" +
	    						" RIGHT JOIN ORDERDETAIL_TABLE USING(order_id)" +
	    						" LEFT JOIN USER_TABLE USING(user_number)" +
	    						" LEFT JOIN PIZZA_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZA_TABLE.pizza_id" +
	    						" LEFT JOIN PIZZAOPTION_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZAOPTION_TABLE.pizzaoption_id" +
	    						" LEFT JOIN SIDE_TABLE ON ORDERDETAIL_TABLE.product_id = SIDE_TABLE.side_id" +
	    					" WHERE order_date = CURDATE()" +
	    					" ORDER BY order_id DESC;";

	    	st=cn.prepareStatement(sql);
	    	rs = st.executeQuery();

	    	while(rs.next()) {
	    		Addressee Addressee = new Addressee();

	    		Addressee.setOrder_date(rs.getString(1));
	    		Addressee.setOrderdetail_id(rs.getInt(2));
	    		Addressee.setUser_number(rs.getInt(3));
	    		Addressee.setUser_name(rs.getString(4));
	    		Addressee.setUser_address(rs.getString(5));
	    		Addressee.setCustom_id(rs.getInt(6));
	    		Addressee.setProduct_amount(rs.getInt(7));
	    		Addressee.setOrder_delivery(rs.getBoolean(8));
	    		Addressee.setProduct_id(rs.getInt(9));
	    		Addressee.setProduct_name(rs.getString(10));

	    		list.add(Addressee);
	    	}
	    	al.setAddresseeList(list);

	    }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
	    }
	    return al;
	}
}

