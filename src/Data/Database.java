package Data;

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
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/gradingsystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword(null); 
	}
	
	public static void main(String[] args) {
		insertStudent();	
	}
	
	
	public static void insertStudent(/* Student s */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			ResultSet rs = DbUtil.execute(conn, "Select * from Student");

			rs.moveToInsertRow();
			rs.updateInt(DbUtil.STUDENT_ID, 100);
			rs.updateString(DbUtil.STUDENT_FNAME, "Test Insert");
			rs.updateString(DbUtil.STUDENT_LNAME, "Jenkins");
			rs.updateString(DbUtil.STUDENT_EMAIL, "tijenk@bu.edu");
			rs.updateInt(DbUtil.STUDENT_TYPE, 1);
			rs.insertRow();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		/* RETURN STUDENT */
		return;
		
	}
	
	
	public static void getStudentWithId(int sid) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			String strSelect = "SELECT * FROM Student WHERE studentId = '" + sid + "'";
			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()) {
		        String fname = rset.getString("firstName");
		        String lname = rset.getString("lastName");
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
