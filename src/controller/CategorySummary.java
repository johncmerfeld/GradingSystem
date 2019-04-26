package controller;

import java.util.HashMap;

import model.Student;
import model.StudentInfo;

// Page : https://jus69c.axshare.com/#g=1&p=home_page-p4-v2-forhw
// This handles the functionalities associated with the page where information for a specific category such as homework, 
// is displayed and entered.

public interface CategorySummary extends DashboardBasics{
	
	//Get mean of each gradable item such as Homework 1, Mid term etc.
	public double getGradeableItemMean(int gradeableItemId);
	
	//Get standard deviation of each gradable item such as Homework 1, Mid term etc.
	public double getGradeableItemStandardDeviation(int gradeableItemId);
	
	//ignore this function
	//public String[][] editScore(int courseId, int categoryId, String[][] newScores);
	
	//Returns a 2d array.
	public String[][] getStudentDataIn2dArray(int categoryId);

	//Edit or add scores by providing a 2d array. Returns a 2d array.
	String[][] updateScores(String[][] updatedData, int categoryId, int courseId);
}
