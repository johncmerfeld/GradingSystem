package model;
import java.sql.*;
import com.mchange.v2.c3p0.*;

import model.DbUtil;
import java.util.ArrayList;

public class Database {
	
	private static ComboPooledDataSource dataSource;
	
	static {	
		dataSource = DbUtil.init();
	}
	
	/** 	ADDER FUNCTIONS
	 * 
	 * 		There is one function for each of the 8 tables, which adds an
	 * entirely new row. 
	 */
	public static void addCourse(Course c) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Course " + 
					"(courseName, semester, isActive)" +
					" VALUES (?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(DbUtil.COURSE_NAME - 1, c.getCourseName());
			ps.setString(DbUtil.COURSE_SEMESTER - 1, c.getCourseSemester());
			ps.setInt(DbUtil.COURSE_ACTIVE - 1, c.isActive() ? 1 : 0);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         }	
	}
	
	public static void addStudentType(int typeId, String typeName) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentType " + 
					"(studentType)" +
					" VALUES (?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(DbUtil.STUDENTTYPE_NAME - 1, typeName);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
	}
	
	/* updates Student and Enrolled */
	public static void addStudentToCourse(Student s, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			
			String existenceQuery = "SELECT * FROM Student " +
					"WHERE studentId = " + s.getBUId();
			
			ResultSet existenceResult = DbUtil.execute(conn, existenceQuery);
			
			/* if student doesn't exist at all, first add them to Student table */
			if (! existenceResult.next()) {
				String queryStudent = "INSERT INTO Student " + 
						"(studentId, firstName, middleName, lastName, email, studentType)" +
						" VALUES (?, ?, ?, ?, ?, ?)";
				
				PreparedStatement ps = conn.prepareStatement(queryStudent);

				ps.setInt(DbUtil.STUDENT_ID, s.getBUId());
				ps.setString(DbUtil.STUDENT_FNAME, s.getName().getFirstName());
				ps.setString(DbUtil.STUDENT_MNAME, s.getName().getMiddleName());
				ps.setString(DbUtil.STUDENT_LNAME, s.getName().getLastName());
				ps.setString(DbUtil.STUDENT_EMAIL, s.getEmail());
				ps.setInt(DbUtil.STUDENT_TYPE, s.isGradStudent() ? 2 : 1);
				ps.execute();
			}
			
			String queryEnrolled = "INSERT INTO Enrolled " + 
					"(courseId, studentId)" +
					" VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(queryEnrolled);
			ps.setInt(DbUtil.ENROLLED_CORID, courseId);
			ps.setInt(DbUtil.ENROLLED_SID, s.getBUId());
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCategory(GradableCategory gc, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO Category" + 
					"(categoryName, courseId, percentageWeight)" +
					" VALUES (?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(DbUtil.CATEGORY_NAME - 1, gc.getName());
			ps.setInt(DbUtil.CATEGORY_CORID - 1, courseId);
			ps.setDouble(DbUtil.CATEGORY_WEIGHT - 1, gc.getWeight());
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 
	}
	
	public static void addScoringMethod(int methodId, String method) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO ScoringMethod" + 
					"(scoringMethod)" +
					" VALUES (?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(DbUtil.SCORINGMETHOD_NAME - 1, method);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	         } 
	}
	
	public static void addGradedItem(GradableItem gi, int categoryId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO GradedItem " + 
					"(gradedItemName, categoryId, maxPoints, scoringMethodId, percentageWeight, include)" +
					" VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(DbUtil.GRADEDITEM_NAME - 1, gi.getName());
			ps.setInt(DbUtil.GRADEDITEM_CATID - 1, categoryId);
			ps.setDouble(DbUtil.GRADEDITEM_MAXPOINTS - 1, gi.getMaxPoints());
			ps.setInt(DbUtil.GRADEDITEM_SCORINGMETHOD - 1, gi.getScoringMethod());
			ps.setDouble(DbUtil.GRADEDITEM_WEIGHT - 1, gi.getWeightage());
			ps.setBoolean(DbUtil.GRADEDITEM_INCLUDE - 1, true);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
	}
	
	public static void addStudentGrade(StudentGrade sg) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "INSERT INTO StudentGrade " + 
					"(studentId, gradedItemId, score, notes)" +
					" VALUES (?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(DbUtil.STUDENTGRADE_SID, sg.getStudentId());
			ps.setInt(DbUtil.STUDENTGRADE_GID, sg.getGradableItem().getId());
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
	}
	
	
	/** UPDATER FUNCTIONS
	 * 
	 * 		These functions adjust values in existing table rows
	 */
	
	public static void updateStudentGrade(StudentGrade sg, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String query =  "UPDATE StudentGrade " + 
					   "SET score = ?, notes = ? " + 
					   "WHERE studentId = ? AND gradedItemId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDouble(1, sg.getGrade().getScore());
			ps.setString(2, sg.getGrade().getNote());
			ps.setInt(3, sg.getStudentId());
			ps.setInt(4, courseId);
			
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 
	}
	
	public static void setCommentStudent(int courseId, int sid, String note) {
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String query =  "UPDATE Enrolled " + 
					   "SET notes = ? " + 
					   "WHERE courseId = ? AND studentId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, note);
			ps.setInt(2, courseId);
			ps.setInt(3, sid);
			
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 		
	}
	
	public static void setIncludeGradedItem(int gradedItemId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String query =  "UPDATE GradedItem " + 
					   "SET include = true " + 
					   "WHERE gradedItemId = " + gradedItemId;
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 		
	}

	public static void setExcludeGradedItem(int gradedItemId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String query =  "UPDATE GradedItem " + 
					   "SET include = false " + 
					   "WHERE gradedItemId = " + gradedItemId;
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.execute();
			
	        conn.close();      
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
	}
	
	/**
	 * GETTER FUNCTIONS
	 * 
 	 * 	These should be called from the controllers to retrieve data objects
	 */
	
	public static Course getCourse(int courseId) {
		Course course = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM Course WHERE courseId = " + courseId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			if (rs.next()) {
				course = new Course(rs.getString(DbUtil.COURSE_NAME),
						rs.getString(DbUtil.COURSE_SEMESTER));
				if (rs.getInt(DbUtil.COURSE_ACTIVE) == 0) {
					course.finishCourse();
				}	
				
				course.setCourseId(rs.getInt(DbUtil.COURSE_ID));
			}			
			conn.close();      
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return course;
	}

	public static Student getStudent(int studentId) {
		Student student = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM Student where studentId = " + studentId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			if (rs.next()) {
				Name name = new Name(rs.getString(DbUtil.STUDENT_FNAME),
						rs.getString(DbUtil.STUDENT_MNAME),
						rs.getString(DbUtil.STUDENT_LNAME));
						
				student = new Student(rs.getInt(DbUtil.STUDENT_ID),
						name, rs.getString(DbUtil.STUDENT_EMAIL), 
						rs.getInt(DbUtil.STUDENT_TYPE) == 2);
			}			
			conn.close();      
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return student;
	}
	
	public static ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM Course";
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
				Course course = new Course(rs.getString(DbUtil.COURSE_NAME),
						rs.getString(DbUtil.COURSE_SEMESTER));
				if (rs.getInt(DbUtil.COURSE_ACTIVE) == 0) {
					course.finishCourse();
				}
				
				course.setCourseId(rs.getInt(DbUtil.COURSE_ID));
				
				courses.add(course);			
			}			
			conn.close();      
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return courses;
	}
	
	
	public static StudentInfo getStudentsInfo(int courseId, int sid) {
		Connection conn = null;
		StudentInfo studentInfo = null;
		
		try {
			conn = dataSource.getConnection();

			String queryNotes = "SELECT * FROM Enrolled " +
					"WHERE studentId = " + sid + " AND " +
					"courseId = " + courseId;
			
			ResultSet rs = DbUtil.execute(conn, queryNotes);
			
			String notes = "";
			
			if (rs.next()) {
				notes = rs.getString(DbUtil.ENROLLED_NOTES);
			}
			
			ArrayList<GradableCategory> cats = Database.getCategoriesInCourse(courseId);
			
			ArrayList<CategoryLevelGrade> categoryGrades = new ArrayList<CategoryLevelGrade>();
			
			for (GradableCategory cat : cats) {
				ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
				ArrayList<GradableItem> gis = Database.getGradedItemsInCategory(cat.getId());
				
				for (GradableItem gi : gis) {
					studentGrades.add(Database.getStudentGradeByGradedItem(gi.getId(), sid));
				}
				
				CategoryLevelGrade catLevelGrade = new CategoryLevelGrade(cat);
				catLevelGrade.setStudentGrades(studentGrades);
				
				categoryGrades.add(catLevelGrade);
			}
			
			studentInfo = new StudentInfo(notes, categoryGrades);
			   
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return studentInfo;
	} 
	
	public static ArrayList<Student> getStudentsInCourse(int courseId) {
		
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT s.* FROM Student s, Enrolled e " +
						   "WHERE s.studentId = e.studentId AND " +
						   "e.courseId = " + courseId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
				Name name = new Name(rs.getString(DbUtil.STUDENT_FNAME),
						rs.getString(DbUtil.STUDENT_MNAME),
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
	
	public static ArrayList<GradableCategory> getCategoriesInCourse(int courseId) {
		ArrayList<GradableCategory> cats = new ArrayList<GradableCategory>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM Category " +
						   "WHERE courseId = " + courseId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
						
				GradableCategory cat = new GradableCategory(
						rs.getString(DbUtil.CATEGORY_NAME), 
						rs.getDouble(DbUtil.CATEGORY_WEIGHT));
				cat.setId(rs.getInt(DbUtil.CATEGORY_ID));
				
				cats.add(cat);
			}
			
	        conn.close();      
	        } catch(SQLException e) {
	         e.printStackTrace();
	        }
		
		return cats;
	}
	
	public static ArrayList<ScoringMethod> getScoringMethods()
	{
		ArrayList<ScoringMethod> scoringMethods = new ArrayList<ScoringMethod>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM ScoringMethod";
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
				ScoringMethod scoringMethod = new ScoringMethod(
						rs.getInt(DbUtil.SCORINGMETHOD_ID),
						rs.getString(DbUtil.SCORINGMETHOD_NAME));
				
				scoringMethods.add(scoringMethod);		
			}			
			conn.close();      
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return scoringMethods;
	}
	
	public static ArrayList<StudentType> getAllStudentTypes() {
		ArrayList<StudentType> studentTypes = new ArrayList<StudentType>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM StudentType";
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {
				StudentType studentType = new StudentType(
						rs.getInt(DbUtil.SCORINGMETHOD_ID),
						rs.getString(DbUtil.SCORINGMETHOD_NAME));
				
				studentTypes.add(studentType);		
			}			
			conn.close();      
        } catch(SQLException e) {
         e.printStackTrace();
        }
		return studentTypes;
	}
	
	public static ArrayList<GradableItem> getGradedItemsInCategory(int catId) {
		ArrayList<GradableItem> gradedItems = new ArrayList<GradableItem>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String query = "SELECT * FROM GradedItem " +
						   "WHERE categoryId = " + catId;
			
			ResultSet rs = DbUtil.execute(conn, query);
			
			while (rs.next()) {				
				GradableItem gradedItem = new GradableItem(
						rs.getString(DbUtil.GRADEDITEM_NAME),
						(int) rs.getDouble(DbUtil.GRADEDITEM_MAXPOINTS),
						rs.getInt(DbUtil.GRADEDITEM_SCORINGMETHOD),
						rs.getDouble(DbUtil.GRADEDITEM_WEIGHT));
				
				gradedItem.setId(rs.getInt(DbUtil.GRADEDITEM_ID));
				
				gradedItems.add(gradedItem);
			}
			
	        conn.close();      
	        } catch(SQLException e) {
	         e.printStackTrace();
	        }
		
		return gradedItems;
	}
	
	public static ArrayList<StudentGrade> getGradesByGradedItem(int gradedItemId) {
		ArrayList<StudentGrade> grades = new ArrayList<StudentGrade>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String queryGradable = "SELECT * FROM GradedItem " +
						   "WHERE gradedItemId = " + gradedItemId;
			
			ResultSet rs = DbUtil.execute(conn, queryGradable);
			
			GradableItem gi = new GradableItem(rs.getString(DbUtil.GRADEDITEM_NAME),
					(int) rs.getDouble(DbUtil.GRADEDITEM_MAXPOINTS),
					rs.getInt(DbUtil.GRADEDITEM_SCORINGMETHOD),
					rs.getDouble(DbUtil.GRADEDITEM_WEIGHT));
			
			String queryGrades = "SELECT * FROM StudentGrade " +
					   "WHERE gradedItemId = " + gradedItemId;
		
			rs = DbUtil.execute(conn, queryGrades);
			
			while (rs.next()) {				
				StudentGrade sg = new StudentGrade(rs.getInt(DbUtil.STUDENTGRADE_SID),
						gi, new Grade(rs.getDouble(DbUtil.STUDENTGRADE_SCORE),
								rs.getString(DbUtil.STUDENTGRADE_NOTES)));
				
				grades.add(sg);
			}
			
	        conn.close();      
	        } catch(SQLException e) {
	         e.printStackTrace();
	        }
		
		return grades;
	}
	
	public static StudentGrade getStudentGradeByGradedItem(int gradedItemId, int sid) {
		Connection conn = null;
		StudentGrade studentGrade = null;
		GradableItem gi = null;
		
		try {
			conn = dataSource.getConnection();

			String queryGradable = "SELECT * FROM GradedItem " +
						   "WHERE gradedItemId = " + gradedItemId;

			ResultSet rs = DbUtil.execute(conn, queryGradable);
			
			if (rs.next()) {
				gi = new GradableItem(rs.getString(DbUtil.GRADEDITEM_NAME),
						(int) rs.getDouble(DbUtil.GRADEDITEM_MAXPOINTS),
						rs.getInt(DbUtil.GRADEDITEM_SCORINGMETHOD),
						rs.getDouble(DbUtil.GRADEDITEM_WEIGHT));
			}
			String queryGrades = "SELECT * FROM StudentGrade " +
					   "WHERE gradedItemId = " + gradedItemId + 
					   " AND studentId = " + sid;
		
			rs = DbUtil.execute(conn, queryGrades);
			
			if (rs.next()) {				
				studentGrade = new StudentGrade(rs.getInt(DbUtil.STUDENTGRADE_SID),
						gi, new Grade(rs.getDouble(DbUtil.STUDENTGRADE_SCORE),
								rs.getString(DbUtil.STUDENTGRADE_NOTES)));
			}
			
	        conn.close();      
	        } catch(SQLException e) {
	         e.printStackTrace();
	        }
		
		return studentGrade;
	}
	
	public static boolean checkIfIncludedGradedItem(int gradedItemId) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();

			String queryGradable = "SELECT * FROM GradedItem " +
						   "WHERE gradedItemId = " + gradedItemId;
			
			ResultSet rs = DbUtil.execute(conn, queryGradable);
			
			conn.close();  
			return rs.getBoolean(DbUtil.GRADEDITEM_INCLUDE);
			
	        } catch(SQLException e) {
	         e.printStackTrace();
	        }
		
		return false;
	}
	
	/**
	 * DELETER FUNCTIONS
	 * 
	 * 		These functions remove rows from tables (may have cascading effects!)
	 */
	
	public static void removeStudentFromCourse(int studentId, int courseId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "DELETE FROM Enrolled " +
					"WHERE studentId = ? AND courseId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			
			ps.execute();
			
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
		
	}
	
	public static void setDeleteGradedItem(int gradedItemId) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String query = "DELETE FROM GradedItem " +
					"WHERE gradedItemId = " + gradedItemId;
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.execute();
			
		} catch(SQLException e) {
	         e.printStackTrace();
	      } 	
		return;	
	}
}

