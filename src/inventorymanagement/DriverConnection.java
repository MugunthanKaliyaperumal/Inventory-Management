package inventorymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DriverConnection {
    private static Connection connection;
    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "Inventory", "bootteam");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"in driver connection class"+ e);
        }
        return connection;
    }
}
