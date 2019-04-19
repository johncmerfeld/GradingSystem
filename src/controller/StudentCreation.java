package controller;

import java.util.HashMap;

import model.Student;

//Page : https://jus69c.axshare.com/#g=1&p=create_student-p5-2

public interface StudentCreation {
	HashMap<Integer, String> getAllStudentTypes();
	Student createStudent(int courseId, String firstName, char middleInitial, String lastName, String email, String BUI_Id, int studentTypeId);
}
