import java.util.*;
import java.sql.*;
public class DatabaseOperations{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prac";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            createRecord(statement, "Happy Junnu", 50000);

            readRecords(statement);
            updateRecord(statement, 1, "Happy Updated", 55000);
            readRecords(statement);
            deleteRecord(statement, 1);
            readRecords(statement);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //private static void delete
    private static void deleteRecord(Statement statement,int id) throws SQLException{
       String deleteQuery = "DELETE FROM employees WHERE id = " + id;
        statement.executeUpdate(deleteQuery);
        System.out.println("Record deleted successfully.\n");
    }
    private static void updateRecord(Statement statement,int id,String name,int salary) throws SQLException{
      String query="Update employees set name='"+name+"' ,  salary="+salary+" where id="+id;
      statement.executeUpdate(query);
      System.out.println("Record updated succcesfuly");
    }
    private static void createRecord(Statement statement,String name,int salary) throws SQLException{
      String query="INSERT INTO employees (name,salary) VALUES('"+name+"',"+salary+")";
      statement.executeUpdate(query);
      System.out.println("Record created succcesfuly");
    }
    private static void readRecords(Statement stmt) throws SQLException{
      String qString="Select * from employees";
      ResultSet resultSet=stmt.executeQuery(qString);
      System.out.println("ID\tname\tSalary");
      System.out.println("------------------------");
      while(resultSet.next()){
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        int salary=resultSet.getInt("salary");
        System.out.println(id + "\t" + name + "\t\t" + salary);
      }
      System.out.println();
      resultSet.close();
    }
}