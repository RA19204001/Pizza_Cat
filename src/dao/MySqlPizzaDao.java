//2021年1月29日11時21分 いが


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Product;
import exception.IntegrationException;

public class MySqlPizzaDao implements PizzaDao{
	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;
//------------------------------------------------------------------------------
    public void addPizza(Product p) {
    	try {
    		String sql = "insert into PIZZA_TABLE(pizza_name, pizza_image, pizza_explanation, pizza_price) value(?,?,?,?)";

    		st = cn.prepareStatement(sql);

    		st.setString(1, p.getName());
    		st.setString(2, p.getImage());
    		st.setString(3, p.getExplanation());
    		st.setInt(4, p.getPrice());

    		st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(), e);
    	}

    }

    public Product getPizza(String id) {
    	Product p =new Product();
    	/*
    	try {
    		String sql="select pizza_name, pizza_image, pizza_explanation, pizza_price from PIZZA_TABLE where PIZZA_ID=?";

    		st=cn.prepareStatement(sql);
    		st.setString(1,id);
    		rs=st.executeQuery();

    		if(rs.next()) {
    			p.setName(rs.getString(1));
    			p.setImage(rs.getString(2));
    			p.setExplanation(rs.getString(3));
    			p.setPrice(rs.getInt(4));
    		}else {

    			throw new IntegrationException("",new Throwable());
    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}
    	*/
    	return p;

    }

    public Product editPizza(String id, Product p) {

    	return p;
    }


}