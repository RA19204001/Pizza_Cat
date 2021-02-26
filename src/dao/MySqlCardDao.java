package dao;

//01.29 移行 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Card;
import exception.AddCardFailedException;
import exception.EditUserFailedException;
import exception.IntegrationException;
import exception.UnUniquUserIdException;

public class MySqlCardDao implements CardDao{
    Connection cn = MySqlConnectionManager.getInstance().getConnection();
    PreparedStatement st = null;
    ResultSet rs=null;


    public void addCard(Card c){
        try{

            String sql = "insert into CARD_TABLE(creditnumber, security_code, expiration_date, mail_address)"+"value(?,?,?,?)";

            st = cn.prepareStatement(sql);

            st.setString(1,c.getCreditnumber());
            st.setString(2,c.getSecurity_code());
            st.setString(3,c.getException_date());
            st.setString(4,c.getMail_address());

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new AddCardFailedException(e.getMessage(),e);

        }
    }
    public Card getCardId(String creditnumber,String security_code) {
    		Card card = new Card();
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

  //引数に古いID(hiddun用)
    public void editCard(String card_id,Card card) {
    	try {
    		String sql = "update CARD_TABLE creditnumber=?, security_code=?, expiration_date=?, mail_address=? where card_id=?";

    		st = cn.prepareStatement(sql);

            st.setString(1,card.getCreditnumber());
            st.setString(2,card.getSecurity_code());
            st.setString(3,card.getException_date());
            st.setString(4,card.getMail_address());
            st.setString(5,card.getCard_id());
            //古いID
            st.setString(6, card_id);

            st.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    		throw new EditUserFailedException(e.getMessage(),e);
    	}

    }

}
