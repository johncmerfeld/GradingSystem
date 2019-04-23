package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Course;
import model.Database;
import model.Student;
import model.StudentInfo;

public abstract class DashboardBasicsController implements DashboardBasics{
	
	protected HashMap<Student, StudentInfo> dashboardInfo;
	
	public DashboardBasicsController(int courseId)
	{
		HashMap<Student, StudentInfo> dashboardInfo = setDashboardInfo(courseId);
		this.dashboardInfo = dashboardInfo;
	}
	
	public HashMap<Student, StudentInfo> setDashboardInfo(int courseId)
	{
		HashMap<Student, StudentInfo> dashboardInfo = new HashMap<Student, StudentInfo>();
		ArrayList<Student> students = Database.getStudentsInCourse(courseId);
		for(Student s : students)
		{
			StudentInfo studentInfo = findStudentInfo(courseId, "U" + s.getBUId());
			dashboardInfo.put(s, studentInfo);
		}
		return dashboardInfo;
		
	}
	
	@Override
	public HashMap<Student, StudentInfo> getDashboardInfo(int courseId) {
		return dashboardInfo;
	}

	@Override
	public Student findStudent(String BU_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentInfo findStudentInfo(int courseId, String BU_Id) {
		String bu_id_num = BU_Id.substring(1);
		int bu_id = Integer.parseInt(bu_id_num);	
		StudentInfo studentInfo = Database.getStudentsInfo(courseId, bu_id);
		return studentInfo;
	}
	

	public Course getCourse(int courseId) {
		Course course = Database.getCourse(courseId);
		return null;
	}
}
