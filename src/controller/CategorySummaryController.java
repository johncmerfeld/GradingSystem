package controller;

import java.util.HashMap;
import java.util.List;
import model.CategoryLevelGrade;
import model.Database;
import model.Student;
import model.StudentGrade;
import model.StudentInfo;

public class CategorySummaryController extends CategoryInformationController implements CategorySummary{

	public CategorySummaryController(int courseId) {
		super(courseId);
	}

	@Override
	public HashMap<Student, StudentInfo> editScore(int courseId, HashMap<Student, StudentInfo> newScores) {
		for (HashMap.Entry<Student, StudentInfo> entry : newScores.entrySet()) {
		    Student s = entry.getKey();
			StudentInfo si = entry.getValue();
		    List<CategoryLevelGrade> categoryLevelGrades = si.getCategoryLevelGrades();
		    for(CategoryLevelGrade cg : categoryLevelGrades)
		    {
		    	for(StudentGrade sg : cg.getStudentGrades())
		    	{
		    		if(dashboardInfo.get(s).getCategoryLevelGrades().contains(sg))
			    	{
		    			Database.updateStudentGrade(sg, courseId);
			    	}
		    		
		    		else
		    		{
		    			Database.addStudentGrade(sg);
		    		}
		    	}
		    }
		}
		setDashboardInfo(courseId);
		return this.dashboardInfo;
	}

	@Override
	public String[][] getStudentDataIn2dArray(int categoryId) {
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
		    	if(cg.getCategory().getId() == categoryId)
		    	{
		    		for(StudentGrade sg : cg.getStudentGrades())
		    		{
		    			data[row_index][col_index++] = sg.getGrade().getScore() + "";
		    		}	
		    	}
		    	
		    }
		}
		return data;
	}
	
	public HashMap<Student, StudentInfo> convert2dArrayToHashmap(String[][] updatedData, int categoryId)
	{
		int num_col = 2 + 4;
		int num_rows = dashboardInfo.size();
		int row_index = 0;
		
		for(row_index = 0; row_index<num_rows; row_index++)
		{
			Student student = Database.getStudent(Integer.parseInt(updatedData[row_index][0]));
			
			StudentInfo studentInfo = dashboardInfo.get(student);
			
			List<CategoryLevelGrade> list_clg = studentInfo.getCategoryLevelGrades();
			
			int col_index = 0;
			
			for(CategoryLevelGrade clg : list_clg)
			{
				if(clg.getCategory().getId() == categoryId)
				{
					for(StudentGrade sg : clg.getStudentGrades())
					{
						sg.getGrade().setScore(Integer.parseInt(updatedData[row_index][col_index++]));
					}
				}
				
			}
			
			dashboardInfo.put(student, studentInfo);
		}
		
		return dashboardInfo;
	}

}
