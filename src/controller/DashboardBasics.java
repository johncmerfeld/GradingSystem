package controller;

import java.util.HashMap;

import model.Student;
import model.StudentInfo;

public interface DashboardBasics {
	//Get a hashmap of all students belonging to a course and their entire info relevant to that course
	public HashMap<Student, StudentInfo>  getDashboardInfo(int courseId);
	//Find information of a specific student
	public Student findStudent(String BU_Id);
	public StudentInfo findStudentInfo(int courseId, String BU_Id);	
}
