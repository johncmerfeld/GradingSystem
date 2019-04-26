package controller;

import java.util.ArrayList;
import java.util.Locale.Category;

import model.Course;
import model.GradableCategory;

//https://jus69c.axshare.com/#g=1&p=home_page-p4-v2

public interface CourseworkSummary extends DashboardBasics{
	public double getCategoryLevelMean(int categoryId);
	public Course  getCourse(int courseId);
	public String[][] getStudentDataIn2dArray();
	public ArrayList<GradableCategory> getAllCategories(int courseId);
}
