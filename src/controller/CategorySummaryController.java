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

}
