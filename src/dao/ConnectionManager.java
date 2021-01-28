package dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionManager {
 	protected static ConnectionManager manager = null;
    protected Connection cn = null;

    //note:apply Singleton with the Class extends this Class.

    abstract Connection getConnection();

    public void closeConnection(){
        try{
            if(cn != null)
                cn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        cn = null;
    }

    public void beginTransaction(){
        if(cn == null)
            cn = getConnection();
        try{
            cn.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try{
            cn.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try{
            cn.rollback();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
