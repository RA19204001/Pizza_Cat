package dao;

//2.9 大川
//2/12 大川
//0220
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;
import exception.EditUserFailedException;
import exception.IntegrationException;

public class MySqlSideDao implements SideDao{
	Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;
    Product product = new Product();

    public void addSide(Product p) {
    	try {
    		String sql = "insert into SIDE_TABLE(side_name, side_image, side_explanation, side_price,side_category)"+ "value(?,?,?,?,?)";

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

    public ArrayList getSide() {
    	ArrayList list = new ArrayList();

    	try {
    		String sql="select side_id, side_name, side_image, side_explanation, side_price, side_display, side_category from SIDE_TABLE where side_display = 1";

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

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;
    }

    public ArrayList getHideSide() {
    	ArrayList list = new ArrayList();

    	try {
    		String sql="select side_id, side_name, side_image, side_explanation, side_price, side_display, side_category from SIDE_TABLE where side_display = 0";

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

    			list.add(p);

    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}

    	return list;
    }

    public void editSide(String id, Product p) {
    	try {
    		String sql = "update SIDE_TABLE set side_name=?, side_explanation=?, side_price=?, side_display=?, side_category=? where side_id=?";

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
    public Product getSideId(String name,String explanation) {

		try {

			String sql = "select side_id from SIDE_TABLE order by side_id desc";

			st=cn.prepareStatement(sql);



			rs = st.executeQuery();
			rs.next();
			product.setProduct_id(rs.getString(1));

		}catch(SQLException e){
			e.printStackTrace();
			throw new IntegrationException(e.getMessage(),e);
		}
		return product;
    }
    public void updateSideImage(String product_id){

    	try {
    		String sql = "update SIDE_TABLE set side_image=? where side_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,Integer.toString(Integer.parseInt(product_id)+1)+".jpg");
            st.setString(2,Integer.toString(Integer.parseInt(product_id)+1));

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }
    public void editDisplaySide(String product_id, Product p) {
    	try {
    		String sql = "update SIDE_TABLE set side_display=? where side_id=?";

    		st = cn.prepareStatement(sql);

            st.setInt(1,p.getProduct_display());
            st.setString(2,product_id);

            System.out.println("(mysql)idは"+ product_id);
    		System.out.println("(mysql)displayは"+ p.getProduct_display());

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}
    }

}
