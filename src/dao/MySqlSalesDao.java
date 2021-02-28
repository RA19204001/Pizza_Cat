//0221染谷
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Sale;
import bean.Sales;
import exception.IntegrationException;

public class MySqlSalesDao implements SalesDao {

	@Override
	public Sales getSales(String startDate, String endDate) {
		//引数は"yyyy-mm-dd"の形式で
		Connection cn = MySqlConnectionManager.getInstance().getConnection();
	    PreparedStatement st = null;
	    ResultSet rs=null;
	    Sales sales = new Sales();
	    ArrayList<Sale> list = new ArrayList<Sale>();

	    try {
	    	String sql = ("SELECT order_date,order_id,user_number,user_name,orderdetail_id,custom_id, " +
	    					"IFNULL(pizza_id,IFNULL(pizzaoption_id,side_id)) AS product_id, " +
	    					"IFNULL(pizza_name,IFNULL(pizzaoption_name,side_name)) AS product_name, " +
	    					"IFNULL(pizza_category,IFNULL(pizzaoption_category,side_category)) AS product_category, " +
	    					"IFNULL(pizza_price,IFNULL(pizzaoption_price,side_price)) AS product_price, " +
	    					"product_amount,order_payment " +
	    				"FROM ORDER_TABLE " +
	    					"RIGHT JOIN ORDERDETAIL_TABLE USING(order_id) " +
	    					"LEFT JOIN USER_TABLE USING(user_number) " +
	    					"LEFT JOIN PIZZA_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZA_TABLE.pizza_id " +
	    					"LEFT JOIN PIZZAOPTION_TABLE ON ORDERDETAIL_TABLE.product_id = PIZZAOPTION_TABLE.pizzaoption_id " +
	    					"LEFT JOIN SIDE_TABLE ON ORDERDETAIL_TABLE.product_id = SIDE_TABLE.side_id " +
	    				"WHERE ? <= order_date AND order_date <= ? " +
	    				"ORDER BY order_id " +
	    				";");

	    	st=cn.prepareStatement(sql);
	    	st.setDate(1, Date.valueOf(startDate));
	    	st.setDate(2, Date.valueOf(endDate));

	    	rs = st.executeQuery();

	    	while(rs.next()) {
	    		Sale sale = new Sale();
	    		sale.setOrder_date(rs.getString(1));
	    		sale.setOrder_id(rs.getInt(2));
	    		sale.setUser_number(rs.getInt(3));
	    		sale.setUser_name(rs.getString(4));
	    		sale.setOrderdetail_id(rs.getInt(5));
	    		sale.setCustom_id(rs.getInt(6));
	    		sale.setProduct_id(rs.getInt(7));
	    		sale.setProduct_name(rs.getString(8));
	    		sale.setProduct_category(rs.getString(9));
	    		sale.setProduct_price(rs.getInt(10));
	    		sale.setProduct_amount(rs.getInt(11));
	    		sale.setOrder_payment(rs.getString(12));

	    		list.add(sale);
	    	}
	    	sales.setSaleList(list);


	    }catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
	    }

		return sales;
	}

}
