package controller;

import model.Course;

public interface CourseworkSummary extends DashboardBasics{
	public double getCategoryLevelMean(int categoryId);
	public Course  getCourse(int courseId);
}
