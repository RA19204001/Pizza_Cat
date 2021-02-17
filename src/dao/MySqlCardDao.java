package dao;

//01.29 移行 大川
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Card;
import exception.AddCardFailedException;
import exception.IntegrationException;

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
}
