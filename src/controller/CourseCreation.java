package controller;

import model.Course;

//Page : https://jus69c.axshare.com/#g=1&p=create_new_course-p3

public interface CourseCreation {
	public Course createNewCourse(String courseName, String semester);
	public Course createNewCourseFromTemplate(String courseName, String semester, int courseId);
	public Course createNewCourseWithListOfStudents(String courseName, String semester, String csvFile);
	public Course createNewCourseFromTemplateWithListOfStudents(String courseName, String semester, int courseId, String csvFile);

}
