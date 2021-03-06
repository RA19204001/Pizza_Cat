//2021年1月29日11時21分 いが

//		2  02  16:00 内田
//2.9 大川
//2/12 大川
//0220

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
    		st.setString(2, "image");
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
    		String sql="select pizza_id, pizza_name, pizza_image, pizza_explanation, pizza_price, pizza_display, pizza_category from PIZZA_TABLE where pizza_display = 1";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setImage(rs.getString(3));
    			p.setExplanation(rs.getString(4));
    			p.setPrice(rs.getInt(5));
    			p.setProduct_display(rs.getInt(6));
    			p.setProduct_category(rs.getString(7));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public ArrayList getHidePizza() {

    	ArrayList list = new ArrayList();

    	try {
    		String sql="select pizza_id, pizza_name, pizza_image, pizza_explanation, pizza_price, pizza_display, pizza_category from PIZZA_TABLE where pizza_display = 0";

    		st=cn.prepareStatement(sql);
    		rs=st.executeQuery();

    		while(rs.next()) {
    			Product p = new Product();

    			p.setProduct_id(rs.getString(1));
    			p.setName(rs.getString(2));
    			p.setImage(rs.getString(3));
    			p.setExplanation(rs.getString(4));
    			p.setPrice(rs.getInt(5));
    			p.setProduct_display(rs.getInt(6));
    			p.setProduct_category(rs.getString(7));

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;

    }

    public void editPizza(String id, Product p) {
    	try {
    		String sql = "update PIZZA_TABLE set pizza_name=?, pizza_explanation=?, pizza_price=?, pizza_display=?, pizza_category=? where pizza_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,p.getName());
            st.setString(2,p.getExplanation());
            st.setInt(3,p.getPrice());
            st.setInt(4,p.getProduct_display());
            st.setString(5,p.getProduct_category());

            st.setString(6, id);

            st.executeUpdate();

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }
    public Product getPizzaId(String name,String explanation) {

		try {

			String sql = "select pizza_id from PIZZA_TABLE order by pizza_id desc";

			st=cn.prepareStatement(sql);



			rs = st.executeQuery();
			rs.next();
			product.setProduct_id(rs.getString(1));
			System.out.println(rs.getString(1));

		}catch(SQLException e){
			e.printStackTrace();
			throw new IntegrationException(e.getMessage(),e);
		}
		return product;
    }
    public void updatePizzaImage(String product_id) {

    	try {
    		String sql = "update PIZZA_TABLE set pizza_image=? where pizza_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,Integer.toString(Integer.parseInt(product_id)+1)+".jpg");
            st.setString(2,Integer.toString(Integer.parseInt(product_id)+1));

            st.executeUpdate();

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }

    public void editDisplayPizza(String product_id, Product p) {
    	try {
    		String sql = "update PIZZA_TABLE set pizza_display=? where pizza_id=?";

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
