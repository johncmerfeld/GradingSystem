package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.CategoryLevelGrade;
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
}
