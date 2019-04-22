package controller;

import java.util.HashMap;

import model.Student;
import model.StudentInfo;

//Page : https://jus69c.axshare.com/#g=1&p=home_page-p4-v2-forhw

public interface CategorySummary extends DashboardBasics{
	public double getGradeableItemMean(int gradeableItemId);
	public double getGradeableItemStandardDeviation(int gradeableItemId);
	public HashMap<Student, StudentInfo>  editScore(int courseId, HashMap<Student, StudentInfo> newScores);
}
