package dao;

//2.12 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Product;
import exception.IntegrationException;

public class MySqlPizzaOptionDao implements PizzaOptionDao{
	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;

    public void addPizzaOption(Product p) {
    	try {
    		String sql = "insert into PIZZAOPTION_TABLE(pizzaoption_name, pizzaoption_price, pizzaoption_category) value(?,?,?)";

    		st = cn.prepareStatement(sql);

    		st.setString(1, p.getName());
    		st.setInt(2, p.getPrice());
    		st.setString(3, p.getProduct_category());

    		st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(), e);
    	}


    }

    public Product getPizzaOption(String id) {
    	Product p = new Product();

    	return p;
    }

    public Product editPizzaOption(String id, Product p) {
    	return p;

    }
}