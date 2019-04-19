package controller;

import java.util.HashMap;

import model.Student;
import model.StudentInfo;

public interface DashboardBasics {
	public HashMap<Student, StudentInfo>  getDashboardInfo(int courseId);
	public Student findStudent(String BU_Id);
	public StudentInfo findStudentInfo(int courseId, String BU_Id);	
}
