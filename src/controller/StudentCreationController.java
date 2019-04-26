package controller;

import java.util.ArrayList;

import model.Database;
import model.Name;
import model.Student;
import model.StudentType;

public class StudentCreationController implements StudentCreation {

	public StudentCreationController(){};
	
	@Override
	public ArrayList<StudentType> getAllStudentTypes() {
		ArrayList<StudentType> list_of_student_types = Database.getAllStudentTypes();
		return list_of_student_types;
	}

	@Override
	public Student createStudent(int courseId, String firstName, String middleName, String lastName, String email,
			String BU_Id, int studentTypeId) {
		int bu_id = Integer.parseInt(BU_Id.substring(1));
		Name name = new Name(firstName, middleName, lastName);
		//TODO Using student type as boolean?
		boolean studentType = true;
		if(studentTypeId == 0)
			studentType = false;
		Student student = new Student(bu_id, name, email, studentType);
		Database.addStudentToCourse(student, courseId);
		return student;
	}

}
