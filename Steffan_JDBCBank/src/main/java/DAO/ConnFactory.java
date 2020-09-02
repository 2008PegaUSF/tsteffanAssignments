package DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

    private static ConnFactory cf = new ConnFactory();

    private ConnFactory() {
        super();
    }

    public static synchronized ConnFactory getInstance() {
        if (cf==null) {
            cf = new ConnFactory();
        }
        return cf;
    }


    public Connection getConnection() {
        Connection conn = null;
        Properties prop = new Properties();//allows us to not have to hardcode url and password

        try {
            prop.load(new FileReader("database.properties"));
            try {
                Class.forName(prop.getProperty("driver"));
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            conn= DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
