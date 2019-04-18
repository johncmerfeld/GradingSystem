package Backend;

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
		addStudent();	
	}
	
	/** 	NEW ROW FUNCTIONS
	 * 
	 * 		There is one function for each of the 8 tables, which adds an
	 * entirely new row. 
	 */
	public static void addCourse(/* Course c */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Course " + 
					"(courseId, courseName, semester, isActive)" +
					" VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.COURSE_ID, 100);
			ps.setString(DbUtil.COURSE_NAME, "Course test");
			ps.setString(DbUtil.COURSE_SEMESTER, "Winter 1901");
			ps.setInt(DbUtil.COURSE_ACTIVE, 1);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         }
		return;		
	}
	
	public static void addStudentType(/* Student type */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentType " + 
					"(studentTypeId, studentType)" +
					" VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.STUDENTTYPE_ID, 100);
			ps.setString(DbUtil.STUDENTTYPE_NAME, "Super student");
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	public static void addStudent(Student s) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Student " + 
					"(studentId, firstName, middleInitial, lastName, email, studentType)" +
					" VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);

			
			
			ps.setInt(DbUtil.STUDENT_ID, 1);
			ps.setString(DbUtil.STUDENT_FNAME, "Test Insert");
			ps.setString(DbUtil.STUDENT_MI, "X");
			ps.setString(DbUtil.STUDENT_LNAME, "Jenkins");
			ps.setString(DbUtil.STUDENT_EMAIL, "tijenk@bu.edu");
			ps.setInt(DbUtil.STUDENT_TYPE, 1);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	public static void addEnrollment(/* Enrollement info, notes */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Enrolled " + 
					"(courseId, studentId, notes)" +
					" VALUES (?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.ENROLLED_CORID, 100);
			ps.setInt(DbUtil.ENROLLED_SID, 100);
			// if notes == null, do blank perhaps...
			ps.setString(DbUtil.ENROLLED_NOTES, "");
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	public static void addCategory(/* Category info */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Category" + 
					"(categoryId, categoryName, courseId, percentageWeight)" +
					" VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.CATEGORY_ID, 100);
			ps.setString(DbUtil.CATEGORY_NAME, "HOMEWORK");
			ps.setInt(DbUtil.CATEGORY_CORID, 100);
			ps.setInt(DbUtil.CATEGORY_WEIGHT, 1);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	public static void addScoringMethod(/* Scoring method */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO ScoringMethod" + 
					"(scoringMethodId, scoringMethod)" +
					" VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.SCORINGMETHOD_ID, 100);
			ps.setString(DbUtil.SCORINGMETHOD_NAME, "No points!");
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	public static void addGradedItem(/* GradedItem */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Course " + 
					"(gradedItemId, gradedItemName, categoryId, maxPoints, scoringMethodId, percentageWeight)" +
					" VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.GRADEDITEM_ID, 100);
			ps.setString(DbUtil.GRADEDITEM_NAME, "HW 10");
			ps.setInt(DbUtil.GRADEDITEM_CATID, 100);
			ps.setDouble(DbUtil.GRADEDITEM_MAXPOINTS, 50.0);
			ps.setInt(DbUtil.GRADEDITEM_SCORINGMETHOD, 1);
			ps.setDouble(DbUtil.GRADEDITEM_WEIGHT, 0.0);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	public static void addStudentGrade(/* student grade info, notes */) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentGrade " + 
					"(studentId, gradedItemId, score, notes)" +
					" VALUES (?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.STUDENTGRADE_SID, 100);
			ps.setInt(DbUtil.STUDENTGRADE_GID, 100);
			ps.setDouble(DbUtil.STUDENTGRADE_SCORE, 60.0);
			// if notes != null ?
			ps.setString(DbUtil.STUDENTGRADE_NOTES, "");
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	
	/** UPDATER FUNCTIONS
	 * 
	 * 		These functions adjust values in existing table rows
	 */
	
	public void updateStudentGrade(/*placeholder*/) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String query =  "UPDATE StudentGrade " + 
					   "SET score = ?, notes = ? " + 
					   "WHERE studentId = ? AND gradedItemId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			rs.updateInt(columnIndex, x);
			rs.updateRow();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
}
