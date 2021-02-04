package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 2.4 変更 大川
import bean.Card;
import bean.User;
import exception.AddUserFailedException;
import exception.EditUserFailedException;
import exception.IntegrationException;
import exception.LoginFailedException;
import exception.UnUniquUserIdException;

public class MySqlUserDao implements UserDao {
    Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;


    public void addUser(User u){
        try{

            String sql = "insert into USER_TABLE(user_id, user_pass, user_name, user_address, user_age, user_point, user_phonenumber)"+"value(?,?,?,?,?,?,?)";



            st = cn.prepareStatement(sql);

            st.setString(1,u.getId());
            st.setString(2,u.getPass());
            st.setString(3,u.getName());
            st.setString(4,u.getAddress());
            st.setInt(5,u.getAge());
            st.setInt(6,0);
            st.setString(7,u.getPhoneNumber());
            // st.setInt(8,u.getCard_id()); //クレジットカード登録が入力欄にない

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new AddUserFailedException(e.getMessage(),e);

        }
    }
    public User getUser(String id, String pass){
    	return null;
    }
    public boolean isUniqueUserId(String id){
        boolean flag=true;
        try{
            String sql="select count(user_number) from USER_TABLE where user_id=?";

            st=cn.prepareStatement(sql);

            st.setString(1,id);
            rs=st.executeQuery();
            rs.next();
            String count=rs.getString(1);
            System.out.println(count);
            if(count.equals("1")){
                flag=false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new UnUniquUserIdException(e.getMessage(),e);
        }
        System.out.println(flag);
        return flag;
    }

    public User authenticateUser(String id, String pass){
    	User user=new User();
    	try {
    		String sql="select USER_ID, USER_PASS,USER_NAME,USER_ADDRESS,USER_AGE,USER_PHONENUMBER from USER_TABLE where USER_ID=? AND USER_PASS=?";

    		st=cn.prepareStatement(sql);
    		st.setString(1,id);
    		st.setString(2,pass);
    		rs=st.executeQuery();

    		if(rs.next()) {
    			user.setId(rs.getString(1));
    			user.setPass(rs.getString(2));
    			user.setName(rs.getString(3));
    			user.setAddress(rs.getString(4));
    			user.setAge(rs.getInt(5));
    			user.setPhoneNumber(rs.getString(6));
    		}else {

    			throw new LoginFailedException("",new Throwable());
    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new IntegrationException(e.getMessage(),e);
    	}
    	return user;
    }

    //引数に古いIDもってきてぇぇぇぇええ
    public void editUser(String id, User user) {
    	try {
    		String sql = "update user_table set user_id=?, user_pass=?, user_name=?, user_address=?, user_age=?, user_point=?, user_phonenumber=? where user_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,user.getId());
            st.setString(2,user.getPass());
            st.setString(3,user.getName());
            st.setString(4,user.getAddress());
            st.setInt(5,user.getAge());
            st.setInt(6,0);
            st.setString(7,user.getPhoneNumber());
            // st.setInt(8,u.getCard_id()); //クレジットカード登録が入力欄にない
            //古いID
            st.setString(8, id);

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}

    }

    public void addCardId(String id,Card card_id) {
        try {
            String sql = "update USER_TABLE set card_id = ? where user_id = ?";

            st = cn.prepareStatement(sql);

             st.setString(1, card_id.getCreditnumber());
             st.setString(2, id);

             st.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
        }
    }
}
