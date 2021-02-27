package dao;

//01.29 移行 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Card;
import exception.AddCardFailedException;
import exception.EditCardFailedException;
import exception.IntegrationException;
import exception.LoginFailedException;
import exception.UnUniquUserIdException;

public class MySqlCardDao implements CardDao{
    Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;
	Card card = new Card();
	ArrayList list = new ArrayList();

    public void addCard(Card c){
        try{

            String sql = "insert into CARD_TABLE(creditnumber, security_code, expiration_date, mail_address)"+"value(?,?,?,?)";

            st = cn.prepareStatement(sql);

            st.setString(1,c.getCreditnumber());
            st.setString(2,c.getSecurity_code());
            st.setString(3,c.getExpiration_date());
            st.setString(4,c.getMail_address());

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new AddCardFailedException(e.getMessage(),e);

        }
    }
    public Card getCardId(String creditnumber,String security_code) {
    	try {

    		String sql = "select card_id from CARD_TABLE where creditnumber = ? AND security_code = ?";

    		st=cn.prepareStatement(sql);

    		st.setString(1,creditnumber);
    		st.setString(2,security_code);


    		rs = st.executeQuery();
    		rs.next();
    		card.setCard_id(rs.getString(1));

    	}catch(SQLException e){
            e.printStackTrace();
            throw new IntegrationException(e.getMessage(),e);
    	}
    	return card;
    }

    public boolean isUniqueCardId(String creditnumber){
        boolean flag=true;
        try{
            String sql="select count(card_id) from CARD_TABLE where creditnumber=?";

            st=cn.prepareStatement(sql);

            st.setString(1,creditnumber);
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
    public ArrayList getCard(String card_id) {

    	try {
    		String sql = "select creditnumber,security_code,expiration_date,mail_address from CARD_TABLE where card_id=?";

    		st = cn.prepareStatement(sql);

    		st.setString(1,card_id);

    		rs=st.executeQuery();
    		if(rs.next()) {
    			card.setCreditnumber(rs.getString(1));
    			card.setSecurity_code(rs.getString(2));
    			card.setExpiration_date(rs.getString(3));
    			card.setMail_address(rs.getString(4));
    			list.add(card);
    		}else {

    			throw new LoginFailedException("",new Throwable());
    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditCardFailedException(e.getMessage(),e);
    	}
    	return list;
    }
    public Card getCardNumber(String card_id) {

    	try {
    		String sql = "select creditnumber,security_code,expiration_date,mail_address from CARD_TABLE where card_id=?";

    		st = cn.prepareStatement(sql);

    		st.setString(1,card_id);

    		rs=st.executeQuery();
    		if(rs.next()) {
    			card.setCreditnumber(rs.getString(1));
    			card.setSecurity_code(rs.getString(2));
    			card.setExpiration_date(rs.getString(3));
    			card.setMail_address(rs.getString(4));
    		}else {

    			throw new LoginFailedException("",new Throwable());
    		}

    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditCardFailedException(e.getMessage(),e);
    	}
    	return card;
    }

}
