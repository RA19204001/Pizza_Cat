package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionManager extends ConnectionManager {
	private MySqlConnectionManager(){}

    public static ConnectionManager getInstance(){
        if(manager == null){
            manager = new MySqlConnectionManager();
        }
        return manager;
    }

    public Connection getConnection(){
        if(cn == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/orcl?characterEncoding=UTF-8&serverTimezone=JST",
                    "pizzacat","pizza");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cn;
    }
}
