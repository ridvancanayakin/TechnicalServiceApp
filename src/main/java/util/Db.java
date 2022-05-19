package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/technical_support";
    String userName = "root";
    String password = "";
    private Connection connection = null;

    public Connection connect(){

        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        }catch ( Exception e ){
            System.err.println("Connection error : " + e);
        }
        return connection;
    }

    public void close(){
        try{
            connection.close();
        }catch ( Exception e){
            System.err.println("Close error : " + e);
        }
    }
}
