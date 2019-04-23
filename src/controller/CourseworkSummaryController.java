package controller;

import java.util.HashMap;
import java.util.List;
import model.CategoryLevelGrade;
import model.Course;
import model.Student;
import model.StudentInfo;

public class CourseworkSummaryController extends DashboardBasicsController implements CourseworkSummary{

	public CourseworkSummaryController(int courseId) {
		super(courseId);
	}

	@Override
	public double getCategoryLevelMean(int categoryId) {
		double total = 0;
		int count = 0;
		for (HashMap.Entry<Student, StudentInfo> entry : dashboardInfo.entrySet()) {
		    StudentInfo si = entry.getValue();
		    List<CategoryLevelGrade> categoryLevelGrades = si.getCategoryLevelGrades();
		    for(CategoryLevelGrade cg : categoryLevelGrades)
		    {
		    	if(cg.getCategory().getId() == categoryId)
		    	{
		    		total = total + cg.getCompositeScore();
		    		count++;
		    	}
		    }
		}
		return total/count;
	}
	
	public String[][] getStudentDataIn2dArray()
	{		
		int num_col = 2 + 4;
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
		    for(CategoryLevelGrade cg : categoryLevelGrades)
		    {
		    	data[row_index][col_index++] = cg.getCompositeScore() + "";
		    }
		}
		
		return data;
	}
}
