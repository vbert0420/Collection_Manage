import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author johnn
 */
public class Database {
    String url = "jdbc:mysql://localhost:3306/payor";
    String username = "root";
    String password = "123456";
Connection connection;
    public void startConnection(){
    try {
     connection = DriverManager.getConnection(url, username, password);
    // Connection successful, you can now work with the database
} catch (SQLException e) {
        // Connection error, handle the exception

}
    }
    
   public  List<Integer> selectPayor(){
       List<Integer> list = new ArrayList<Integer>();
    String sqlQuery = "select purpose, sum(amount) AS `purpose_sum` from payor group by `purpose`;";
    try {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sqlQuery);
     while (resultSet.next()) {
        int purpose_sum = resultSet.getInt("purpose_sum");
        list.add(purpose_sum);
    }
    // Process the query result
  
} catch (SQLException e) {
    // Handle any SQL errors
    
}
return list;
   }
}
