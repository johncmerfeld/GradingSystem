package controller;

import java.util.ArrayList;
import model.Student;
import model.StudentType;

//Page : https://jus69c.axshare.com/#g=1&p=create_student-p5-2

public interface StudentCreation {
	ArrayList<StudentType> getAllStudentTypes();
	Student createStudent(int courseId, String firstName, char middleInitial, String lastName, String email, String BU_Id, int studentTypeId);
}
