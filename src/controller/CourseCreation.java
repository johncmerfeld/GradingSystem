package controller;

import model.Course;

public interface CourseCreation {
	public Course createNewCourse(String courseName, String semester);
	public Course createNewCourseFromTemplate(String courseName, String semester, int courseId);
	public Course createNewCourseWithListOfStudents(String courseName, String semester, String csvFile);
	public Course createNewCourseFromTemplateWithListOfStudents(String courseName, String semester, int courseId, String csvFile);

}
