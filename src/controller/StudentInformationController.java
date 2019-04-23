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
	
	public HashMap<Student, StudentInfo> convert2dArrayToHashmap(String[][] updatedData, int categoryId, int courseId)
	{
		int num_col = 2 + 4;
		int num_rows = dashboardInfo.size();
		int row_index = 0;
		
		for(row_index = 0; row_index<num_rows; row_index++)
		{
			Student student = Database.getStudent(Integer.parseInt(updatedData[row_index][0]));
			StudentInfo studentInfo = dashboardInfo.get(student);
			
			for(row_index=0; row_index<num_rows; row_index++)
			{
				String new_note = updatedData[row_index][3];
				studentInfo.setNote(new_note);
				addCommentForStudent(courseId, updatedData[row_index][0], new_note);
			}
			
			dashboardInfo = setDashboardInfo(courseId);
		}
		
		return dashboardInfo;
	}

}
