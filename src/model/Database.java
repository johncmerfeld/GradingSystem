package model;

import java.sql.*;
import com.mchange.v2.c3p0.*;

import model.GradeableItem.ScoringMethod;

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
		//addStudent();	
	}
	
	/** 	NEW ROW FUNCTIONS
	 * 
	 * 		There is one function for each of the 8 tables, which adds an
	 * entirely new row. 
	 */
	public static void addCourse(Course c) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Course " + 
					"(courseId, courseName, semester, isActive)" +
					" VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.COURSE_ID, c.getCourseId());
			ps.setString(DbUtil.COURSE_NAME, c.getCourseName());
			ps.setString(DbUtil.COURSE_SEMESTER, c.getCourseSemester());
			ps.setInt(DbUtil.COURSE_ACTIVE, c.isActive() ? 1 : 0);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         }
		return;		
	}
	
	public static void addStudentType(int typeId, String typeName) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentType " + 
					"(studentTypeId, studentType)" +
					" VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.STUDENTTYPE_ID, typeId);
			ps.setString(DbUtil.STUDENTTYPE_NAME, typeName);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	/* updates Student and Enrolled */
	public static void addStudent(Student s, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String queryStudent = "INSERT INTO Student " + 
					"(studentId, firstName, middleInitial, lastName, email, studentType)" +
					" VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(queryStudent);

			ps.setInt(DbUtil.STUDENT_ID, s.getBUId());
			ps.setString(DbUtil.STUDENT_FNAME, s.getName().getFirstName());
			ps.setString(DbUtil.STUDENT_MI, String.valueOf(s.getName().getMiddleInitial()));
			ps.setString(DbUtil.STUDENT_LNAME, s.getName().getLastName());
			ps.setString(DbUtil.STUDENT_EMAIL, s.getEmail());
			ps.setInt(DbUtil.STUDENT_TYPE, s.isGradStudent() ? 2 : 1);
			ps.execute();
			
			String queryEnrolled = "INSERT INTO Enrolled " + 
					"(courseId, studentId)" +
					" VALUES (?, ?)";
			
			ps = conn.prepareStatement(queryEnrolled);
			ps.setInt(DbUtil.ENROLLED_CORID, courseId);
			ps.setInt(DbUtil.ENROLLED_SID, s.getBUId());
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	public static void addCategory(GradableCategory gc, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Category" + 
					"(categoryId, categoryName, courseId, percentageWeight)" +
					" VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.CATEGORY_ID, gc.getId());
			ps.setString(DbUtil.CATEGORY_NAME, gc.getName());
			ps.setInt(DbUtil.CATEGORY_CORID, courseId);
			ps.setDouble(DbUtil.CATEGORY_WEIGHT, gc.getWeight());
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	public static void addScoringMethod(int methodId, String method) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO ScoringMethod" + 
					"(scoringMethodId, scoringMethod)" +
					" VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.SCORINGMETHOD_ID, methodId);
			ps.setString(DbUtil.SCORINGMETHOD_NAME, method);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
		return;		
	}
	
	public static void addGradedItem(GradeableItem gi, int categoryId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Course " + 
					"(gradedItemId, gradedItemName, categoryId, maxPoints, scoringMethodId, percentageWeight)" +
					" VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.GRADEDITEM_ID, gi.getId());
			ps.setString(DbUtil.GRADEDITEM_NAME, gi.getName());
			ps.setInt(DbUtil.GRADEDITEM_CATID, categoryId);
			ps.setDouble(DbUtil.GRADEDITEM_MAXPOINTS, gi.getMaxPoints());
			ps.setInt(DbUtil.GRADEDITEM_SCORINGMETHOD, gi.getScoringMethod() == 
					ScoringMethod.Deduction ? 1 : 2);
			ps.setDouble(DbUtil.GRADEDITEM_WEIGHT, gi.getWeightage());
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
	
	public static void addStudentGrade(StudentGrade sg) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentGrade " + 
					"(studentId, gradedItemId, score, notes)" +
					" VALUES (?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.STUDENTGRADE_SID, 1);
			ps.setInt(DbUtil.STUDENTGRADE_GID, sg.getGradeableItem().getId());
			ps.setDouble(DbUtil.STUDENTGRADE_SCORE, sg.getGrade().getScore());
			String notes = sg.getGrade().getNote();
			if (notes == null) {
				notes = "";
			}
			ps.setString(DbUtil.STUDENTGRADE_NOTES, notes);
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
	
	
	/**
	 * Don't forget about deletes!
	 */
	
	/**
	 * GETTER FUNCTIONS
	 */
	
	ArrayList<Student> getStudentsInCourse(int courseId) {
		
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			/* select * from student */
			String query = "SELECT s.* FROM Student s, Enrolled e " +
						   "WHERE s.studentId = e.studentId AND " +
						   "e.courseId = " + courseId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
				Name name = new Name(rs.getString(DbUtil.STUDENT_FNAME),
						rs.getString(DbUtil.STUDENT_MI).charAt(0),
						rs.getString(DbUtil.STUDENT_LNAME));
						
				Student student = new Student(rs.getInt(DbUtil.STUDENT_ID),
						name, rs.getString(DbUtil.STUDENT_EMAIL), 
						rs.getInt(DbUtil.STUDENT_TYPE) == 2);
				
				students.add(student);
				
			}
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return students;
		
	}
	
	
	
}
