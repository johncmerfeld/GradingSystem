package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;

import model.CategoryLevelGrade;
import model.Database;
import model.GradableCategory;
import model.GradableItem;
import model.Grade;
import model.Student;
import model.StudentGrade;
import model.StudentInfo;

public class CategorySummaryController extends CategoryInformationController implements CategorySummary{

	private ArrayList<GradableItem> listOfGradedItems;
	
	private double convertToRaw(double score, int grading_type, int max_points)
	{
		if(grading_type == 1)
			return max_points + score;
		if(grading_type == 2)
			return (score/100)*max_points;
		return -1;
	}
	
	private double convertRawScoreToActual(double raw_score, int grading_type, int max_points)
	{
		if(grading_type == 1)
			return raw_score - max_points;
		if(grading_type == 2)
			return (raw_score/max_points)*100;
		return -1;
	}
	
	public CategorySummaryController(int courseId) {
		super(courseId);
	}

/*	@Override
	public String[][] editScore(int courseId, int categoryId, String[][] newScores) {
		//Convert 2d array to hashmap
		HashMap<Student, StudentInfo> newScoresHashtable = convert2dArrayToHashmap(newScores, categoryId, courseId);
		for (HashMap.Entry<Student, StudentInfo> entry : newScoresHashtable.entrySet()) {
		    Student s = entry.getKey();
			StudentInfo si = entry.getValue();
		    List<CategoryLevelGrade> categoryLevelGrades = si.getCategoryLevelGrades();
		    for(CategoryLevelGrade cg : categoryLevelGrades)
		    {
		    	for(StudentGrade sg : cg.getStudentGrades())
		    	{
		    		if(dashboardInfo.get(s).getCategoryLevelGrades().contains(sg))
			    	{
		    			Database.updateStudentGrade(sg, sg.getGradableItem().getId());
			    	}
		    		
		    		else
		    		{
		    			Database.addStudentGrade(sg);
		    		}
		    	}
		    }
		}
		setDashboardInfo(courseId);
		return this.getStudentDataIn2dArray(categoryId);
	}

*/
	@Override
	public String[][] getStudentDataIn2dArray(int categoryId) {
		int num_col = 2 + 4;
		int num_rows = dashboardInfo.size() + 2;
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
		    			//Null check for sg
		    			if(sg == null)
		    				continue;
		    			data[row_index][col_index++] = convertRawScoreToActual(sg.getGrade().getScore(), sg.getGradableItem().getScoringMethod(), sg.getGradableItem().getMaxPoints()) + "";
		    		}	
		    	}
		    	
		    }
		    row_index++;
		}
		
		int col_index = 1;
		data[row_index++][col_index++] = "Mean";
		
		if(this.listOfGradedItems != null)
		{
			for(GradableItem gi : this.listOfGradedItems)
			{
				if(gi != null)
					data[row_index][col_index++] = this.getGradeableItemMean(gi.getId()) + "";
			} 

			
			col_index = 1;
			data[row_index++][col_index++] = "Max Points";
			
			for(GradableItem gi : this.listOfGradedItems)
			{
				if(gi != null)
					data[row_index][col_index++] = gi.getMaxPoints() + "";
			} 
		}
		
		

		return data;
	}
	

	@Override
	public String[][] updateScores(String[][] updatedData, int categoryId, int courseId)
	{
		int num_col = 2 + 4;
		int num_rows = dashboardInfo.size();
		int row_index = 0;
		
		for(row_index = 0; row_index<num_rows; row_index++)
		{
			//Find student for each row
			Student student = Database.getStudent(Integer.parseInt(updatedData[row_index][0]));
			
			//Find student info for each row
			StudentInfo studentInfo = dashboardInfo.get(student);
			
			//Each student has a list of category level grades which we find here
			List<CategoryLevelGrade> list_clg = studentInfo.getCategoryLevelGrades();
			
			int col_index = 2;
			
			for(CategoryLevelGrade clg : list_clg)
			{
				//Find correct category
				if(clg.getCategory().getId() == categoryId)
				{
					//Iterate over all the grades of a student that belong to give category
					for(StudentGrade sg : clg.getStudentGrades())
					{
						//Entry in the 2d array
						double score = convertToRaw(Double.parseDouble(updatedData[row_index][col_index]), sg.getGradableItem().getScoringMethod(), sg.getGradableItem().getMaxPoints());
						
						//Add it to the studentgrade
						sg.getGrade().setScore(score);
						
						Database.updateStudentGrade(sg, sg.getGradableItem().getId());
						col_index++;
					}
				}	
			}
			this.setDashboardInfo(courseId);
			dashboardInfo.put(student, studentInfo);
		}
		
		return getStudentDataIn2dArray(categoryId);
	}

	@Override
	public ArrayList<GradableItem> getAllGradedItems(int categoryId) {
		ArrayList<GradableItem> listOfGradedItems = Database.getGradedItemsInCategory(categoryId);
		this.listOfGradedItems = listOfGradedItems;
		return listOfGradedItems;
	}

}
