package controller;

import java.util.HashMap;

import model.Student;

public interface StudentCreation {
	HashMap<Integer, String> getAllStudentTypes();
	Student createStudent(int courseId, String firstName, char middleInitial, String lastName, String email, String BUI_Id, int studentTypeId);
}
