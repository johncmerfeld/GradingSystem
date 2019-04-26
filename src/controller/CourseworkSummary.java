package controller;

import java.util.ArrayList;

import model.Course;

//https://jus69c.axshare.com/#g=1&p=home_page-p4-v2

public interface CourseworkSummary extends DashboardBasics{
	public double getCategoryLevelMean(int categoryId);
	public Course  getCourse(int courseId);
	public String[][] getStudentDataIn2dArray();
	public ArrayList<Course> getAllCourses();
}
