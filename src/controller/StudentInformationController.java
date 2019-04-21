package controller;

import java.util.HashMap;

import model.Database;
import model.Student;
import model.StudentInfo;

public class StudentInformationController extends DashboardBasicsController implements StudentInformation{

	public StudentInformationController(int courseId) {
		super(courseId);
	}

	@Override
	public HashMap<Student, StudentInfo> addCommentForStudent(int courseId, String BU_Id, String note) {
		String intermediate = BU_Id.substring(1);
		int bu_id = Integer.parseInt(intermediate);
		Database.setCommentStudent(courseId, bu_id, note);
		dashboardInfo = this.setDashboardInfo(courseId);
		return dashboardInfo;
	}

}
