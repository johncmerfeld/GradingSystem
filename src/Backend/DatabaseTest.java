package Backend;
import java.sql.*;

// /Users/johncmerfeld/Documents/Code/GradingSystem/mysql-connector-java-8.0.15/mysql-connector-java-8.0.15.jar

public class DatabaseTest {

	public static void main(String[] args) {
		try (
		         // Step 1: Allocate a database 'Connection' object
		         Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/hw1p3?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
		               "root", null);   // For MySQL only
		               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
		 
		         // Step 2: Allocate a 'Statement' object in the Connection
		         Statement stmt = conn.createStatement();
		      ) {
		         // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
		         String strSelect = "select * from Dept";
		         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
		 
		         ResultSet rset = stmt.executeQuery(strSelect);
		 
		         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
		         //  For each row, retrieve the contents of the cells with getXxx(columnName).
		         System.out.println("The records selected are:");
		         int rowCount = 0;
		         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
		            int did = rset.getInt("did");
		        	String dname = rset.getString("dname");
		            double budget = rset.getDouble("budget");
		            int    managerid  = rset.getInt("managerid");
		            System.out.println(did + ", " + dname + ", " + budget + ", " + managerid);
		            ++rowCount;
		         }
		         System.out.println("Total number of records = " + rowCount);
		 
		      } catch(SQLException ex) {
		         ex.printStackTrace();
		      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)

	}

}
