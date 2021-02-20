package dao;

//2.12 大川
//0220
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;
import exception.EditUserFailedException;
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
    		String sql="select pizzaoption_id, pizzaoption_name, pizzaoption_price, pizzaoption_display, pizzaoption_category from PIZZAOPTION_TABLE where pizzaoption_display = 1";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setPrice(rs.getInt(3));
    			p.setProduct_display(rs.getInt(4));
    			p.setProduct_category(rs.getString(5));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public ArrayList getHidePizzaOption() {
    	ArrayList list = new ArrayList();

    	try {
    		String sql="select pizzaoption_id, pizzaoption_name, pizzaoption_price, pizzaoption_display, pizzaoption_category from PIZZAOPTION_TABLE where pizzaoption_display = 0";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setPrice(rs.getInt(3));
    			p.setProduct_display(rs.getInt(4));
    			p.setProduct_category(rs.getString(5));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public void editPizzaOption(String id, Product p) {
    	try {
    		String sql = "update pizzaoption_table set pizzaoption_name=?, pizzaoption_explanation=?, pizzaoption_price=?, pizzaoption_display=?, pizzaoption_category=? where pizzaoption_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,p.getName());
            st.setInt(2,p.getPrice());
            st.setInt(3,p.getProduct_display());
            st.setString(4,p.getProduct_category());

            st.setString(5, id);

            st.executeUpdate();

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}

    }
    public void editDisplayPizzaOption(String product_id, Product p) {
    	try {
    		String sql = "update pizzaoption_table set pizzaoption_display=? where pizzaoption_id=?";

    		st = cn.prepareStatement(sql);

            st.setInt(1,p.getProduct_display());
            st.setString(2,product_id);

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }
}
