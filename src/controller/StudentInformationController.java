package controller;

import java.util.HashMap;
import java.util.List;

import model.CategoryLevelGrade;
import model.Database;
import model.Student;
import model.StudentGrade;
import model.StudentInfo;

public class StudentInformationController extends DashboardBasicsController implements StudentInformation{

	public StudentInformationController(int courseId) {
		super(courseId);
	}

	@Override
	public HashMap<Student, StudentInfo> addCommentForStudent(int courseId, String BU_Id, String note) {
		String intermediate = BU_Id.substring(1);
		int bu_id = Integer.parseInt(intermediate);
		Database.setCommentStudent(courseId, bu_id, note);
		dashboardInfo = this.setDashboardInfo(courseId);
		return dashboardInfo;
	}
	
	// get 2d array with 4 columns: StudentID, StudentName, EMAIL, Note
	@Override
	public String[][] getStudentDataIn2dArray(int courseId) {
		int num_col = 4;
		int num_rows = dashboardInfo.size();
		int row_index = 0;
		
		String[][] data = new String[num_rows][num_col];
		
		for (HashMap.Entry<Student, StudentInfo> entry : dashboardInfo.entrySet()) {
		    Student s = entry.getKey();
			StudentInfo si = entry.getValue();
		    List<CategoryLevelGrade> categoryLevelGrades = si.getCategoryLevelGrades();
		    int col_index = 0;
		    data[row_index][col_index++] = s.getBUId() + "";
	    	data[row_index][col_index++] = s.getName().getName();
	    	data[row_index][col_index++] = s.getEmail();
	    	data[row_index][col_index++] = si.getNote();
		}
		return data;
	}

	@Override
	public String[][] updateStudentInformation(String[][] updatedData, int categoryId, int courseId) {
		int num_col = 4;
		int num_rows = dashboardInfo.size();
		int row_index = 0;
		
		for(row_index = 0; row_index<num_rows; row_index++)
		{
			//Find student for each row
			Student student = Database.getStudent(Integer.parseInt(updatedData[row_index][0]));
			
			//Find student info for each row
			StudentInfo studentInfo = dashboardInfo.get(student);
			
			String note = updatedData[row_index][3];
			
			//Set note
			studentInfo.setNote(note);

			//Save information
			dashboardInfo.put(student, studentInfo);
			Database.setCommentStudent(courseId, student.getBUId(), note);
		}
		
		return getStudentDataIn2dArray(categoryId);
	}
	
	

}
