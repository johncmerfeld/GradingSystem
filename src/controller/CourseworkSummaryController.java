	package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;

import model.CategoryLevelGrade;
import model.Course;
import model.Database;
import model.GradableCategory;
import model.Student;
import model.StudentInfo;

public class CourseworkSummaryController extends DashboardBasicsController implements CourseworkSummary{

	private ArrayList<GradableCategory> listOfCategories;
	
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
		    	if(cg != null)
		    	{
		    		if(cg.getCategory().getId() == categoryId && !Double.isNaN(cg.getCompositeScore()))
			    	{
			    		total = total + cg.getCompositeScore();
			    		count++;
			    	}
		    	}
		    	
		    }
		}
		
		//if(count == 0)
		//	return 0;
		return total/count;
	}
	
	public String[][] getStudentDataIn2dArray(int courseId)
	{		
		int num_col = 2 + this.getAllCategories(courseId).size();
		int num_rows = dashboardInfo.size() + 1;
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
		    	//Null check for CategoryLevelGrade
		    	if(cg == null)
		    		break;
		    	data[row_index][col_index++] = cg.getCompositeScore() + "";
		    }
		    row_index++;
		}
		
		int col_index = 1;
		data[row_index][col_index++] = "Mean";
		
		if(this.listOfCategories != null)
		{
			for(GradableCategory gc : this.listOfCategories)
			{
				if(gc != null)
				{
					data[row_index][col_index] = this.getCategoryLevelMean(gc.getId()) + "";
				}
					
				col_index++;
			} 
		}
		
		
		return data;
	}
	
	@Override
	public ArrayList<GradableCategory> getAllCategories(int courseId) {
		ArrayList<GradableCategory> listOfCategories= Database.getCategoriesInCourse(courseId);
		this.listOfCategories = listOfCategories;
		return listOfCategories;
	}
}
