package dao;

//2.9 大川
//2/12 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    		String sql = "insert into SIDE_TABLE(side_name, side_image, side_explanation, side_price,side_display,side_category)"+ "value(?,?,?,?,?,?)";

    		st = cn.prepareStatement(sql);

    		st.setString(1, p.getName());
    		st.setString(2, p.getImage());
    		st.setString(3, p.getExplanation());
    		st.setInt(4, p.getPrice());
    		st.setString(5, p.getProduct_display());
    		st.setString(6, p.getProduct_category());

    		st.executeUpdate();
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
    public Product getSideId(String name,String explanation) {

		try {

			String sql = "select side_id from SIDE_TABLE where side_name = ? AND side_explanation = ?";

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
    public void updateSideImage(String product_id){

    	try {
    		String sql = "update side_table set side_image=? where side_id=?";

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