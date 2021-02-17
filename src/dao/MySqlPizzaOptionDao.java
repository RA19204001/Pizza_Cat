package dao;

//2.12 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList getPizzaOption() {
    	ArrayList list = new ArrayList();

    	try {
    		String sql="select pizzaoption_id, pizzaoption_name, pizzaoption_price, pizzaoption_display, pizzaoption_category from PIZZAOPTION_TABLE";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setPrice(rs.getInt(3));
    			p.setProduct_display(rs.getBoolean(4));
    			p.setProduct_category(rs.getString(5));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public Product editPizzaOption(String id, Product p) {
    	return p;

    }
}