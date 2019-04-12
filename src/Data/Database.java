import java.sql.*;
import com.mchange.v2.c3p0.*;
import java.util.ArrayList;

public class Database {
	
	private static ComboPooledDataSource dataSource;
	
	static {	
		init();
	}
	
	public static void init() {
		/* connection pool means we don't have to connect completely freshly
		 * every time
		 */
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hw1p3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword(null); 
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> ints = getCourseIds();
		
		for (Integer  myInt : ints) {
			System.out.println(myInt);
		}
	}
	
	public static void getStudentWithId(int sid) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();	
			String strSelect = "SELECT * FROM Student WHERE studentId = '" + sid + "'";
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()) {
		        /* get all student info */
	        }
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		/* RETURN STUDENT */
		return;
	}
	
	public static ArrayList<Integer> getCourseIds() {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();	
			String strSelect = "select * from Dept";
			ResultSet rset = stmt.executeQuery(strSelect);

	        //  For each row, retrieve the contents of the cells with getXxx(columnName).
	        while(rset.next()) {
		        int courseId  = rset.getInt("managerid");
		        intList.add(new Integer(courseId));
	        }
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 			
		return intList;	
	}
}
