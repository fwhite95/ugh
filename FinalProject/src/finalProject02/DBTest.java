package finalProject02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DBTest {

    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub



        System.out.println("Driver loaded");

        //Connect to a database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook",
                "scott", "tiger");
        System.out.println("Database connected");

        //Create a statement
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select address " +
                "from Facility");



        while(rs.next()){
            System.out.println(rs.getString(1));
        }

        //close connection
        connection.close();
        System.out.println("Database disconnected");
    }

}
