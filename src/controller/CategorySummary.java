package controller;

import java.util.HashMap;

import model.Student;
import model.StudentInfo;

public interface CategorySummary extends Coursework{
	public int getGradeableItemMean(int gradeableItemId);
	public int getGradeableItemStandardDeviation(int gradeableItemId);
	public HashMap<Student, StudentInfo>  editScore(int courseId, HashMap<Student, StudentInfo> newScores);
}
