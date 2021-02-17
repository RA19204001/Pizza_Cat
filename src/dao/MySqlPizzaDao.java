//2021年1月29日11時21分 いが

//		2  02  16:00 内田
//2.9 大川
//2/12 大川

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;
import exception.EditUserFailedException;
import exception.IntegrationException;

public class MySqlPizzaDao implements PizzaDao{
	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;
    Product product = new Product();
//------------------------------------------------------------------------------
    public void addPizza(Product p) {
    	try {
    		String sql = "insert into PIZZA_TABLE(pizza_name, pizza_image, pizza_explanation, pizza_price,pizza_category) value(?,?,?,?,?)";

    		st = cn.prepareStatement(sql);

    		st.setString(1, p.getName());
    		st.setString(2, p.getImage());
    		st.setString(3, p.getExplanation());
    		st.setInt(4, p.getPrice());
    		//st.setString(5, p.getProduct_display());
    		st.setString(5, p.getProduct_category());

    		st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(), e);
    	}

    }

    public ArrayList getPizza() {

    	ArrayList list = new ArrayList();

    	try {
    		String sql="select pizza_id, pizza_name, pizza_image, pizza_explanation, pizza_price, pizza_display, pizza_category from PIZZA_TABLE";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setImage(rs.getString(3));
    			p.setExplanation(rs.getString(4));
    			p.setPrice(rs.getInt(5));
    			p.setProduct_display(rs.getBoolean(6));
    			p.setProduct_category(rs.getString(7));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public Product editPizza(String id, Product p) {

    	return p;
    }
    public Product getPizzaId(String name,String explanation) {

		try {

			String sql = "select pizza_id from PIZZA_TABLE where pizza_name = ? AND pizza_explanation = ?";

			st=cn.prepareStatement(sql);

			st.setString(1,name);
			st.setString(2,explanation);


			rs = st.executeQuery();
			rs.next();
			product.setProduct_id(rs.getString(1));

		}catch(SQLException e){
			e.printStackTrace();
			throw new IntegrationException(e.getMessage(),e);
		}
		return product;
    }
    public void updatePizzaImage(String product_id) {

    	try {
    		String sql = "update pizza_table set pizza_image=? where pizza_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,product.getProduct_id()+".jpg");
            st.setString(2,product.getProduct_id());

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }
}