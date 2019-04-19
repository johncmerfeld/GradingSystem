package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.CategoryLevelGrade;
import model.Database;
import model.Student;
import model.StudentInfo;

public class CourseworkSummaryController implements CourseworkSummary{

	private HashMap<Student, StudentInfo> dashboardInfo;
	
	@Override
	public HashMap<Student, StudentInfo> getDashboardInfo(int courseId) {
		HashMap<Student, StudentInfo> dashboardInfo = new HashMap<Student, StudentInfo>();
		ArrayList<Student> students = Database.getStudentsInCourse(courseId);
		for(Student s : students)
		{
			StudentInfo studentInfo = findStudentInfo(courseId, "U" + s.getBUId());
			dashboardInfo.put(s, studentInfo);
		}
		this.dashboardInfo = dashboardInfo;
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

	@Override
	public double getCategoryLevelMean(int categoryId) {
		double total = 0;
		int count = 0;
		for (HashMap.Entry<Student, StudentInfo> entry : dashboardInfo.entrySet()) {
		    StudentInfo si = entry.getValue();
		    List<CategoryLevelGrade> categoryLevelGrades = si.getCategoryLevelGrades();
		    for(CategoryLevelGrade cg : categoryLevelGrades)
		    {
		    	if(cg.getCategory().getId() == categoryId)
		    	{
		    		total = total + cg.getCompositeScore();
		    		count++;
		    	}
		    }
		}
		return total/count;
	}

}
