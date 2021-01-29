package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Product;
import exception.IntegrationException;

public class MySqlSideDao implements SideDao{
	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;

    public void addSide(Product p) {
    	try {
    		String sql = "insert into SIDE_TABLE(side_name, side_image, side_explanation, side_price) value(?,?,?,?)";

    		st = cn.prepareStatement(sql);

    		st.setString(1, p.getName());
    		st.setString(2, p.getImage());
    		st.setString(3, p.getExplanation());
    		st.setInt(4, p.getPrice());
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(), e);
    	}


    }

    public Product getSide(String id) {
    	Product p = new Product();

    	return p;
    }

    public Product editSide(String id, Product p) {

    	return p;
    }
}