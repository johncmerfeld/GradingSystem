package controller;

import java.util.ArrayList;
import java.util.Random;
import model.Course;
import model.Database;
import model.GradableCategory;
import model.GradableItem;
import model.Student;

public class CourseCreationController implements CourseCreation{
	
	public CourseCreationController()
	{}
	
	@Override
	public Course createNewCourse(String courseName, String semester) {
        // Generate random integers in range 0 to 999 
        int rand_int1 = (new Random()).nextInt(1000000); 
		Course course = new Course(rand_int1, courseName, semester);
		Database.addCourse(course);
		return course;
	}

	@Override
	public Course createNewCourseFromTemplate(String courseName, String semester, int courseId) {
		Course course = createNewCourse(courseName, semester);
		//Get list of categories belonging to courseId
		ArrayList<GradableCategory> listOfCategories = Database.getCategoriesInCourse(courseId);
		//Iterate over the list of categories
		for(GradableCategory gc : listOfCategories)
		{
			// Generate random integers in range 0 to 999999 
	        int rand_int1 = (new Random()).nextInt(1000000); 
	        
	        //Copy category information into new object
	        GradableCategory new_gc = gc;
	        
	        //Create new id for it
	        new_gc.setId(rand_int1);
	        
	        //Store category for new course
	        Database.addCategory(new_gc, course.getCourseId());
			
	        //Find list of gradeableItems belonging to each category
			ArrayList<GradableItem> listOfgradeableItems = Database.getGradedItemsInCategory(gc.getId());
			
			//Iterate over list of gradable items
			for(GradableItem gi : listOfgradeableItems)
			{
				// Generate random integers in range 0 to 999999 
		        int rand_int2 = (new Random()).nextInt(1000000); 
		        
		        //Copy gradable item information into new object
		        GradableItem new_gi = gi;
		        
		        //Create new id for it
		        new_gi.setId(rand_int2);
		        
		        //Store item for new category
		        Database.addGradedItem(new_gi, new_gc.getId());
			}
		}
		return course;
	}

	@Override
	public Course createNewCourseWithListOfStudents(String courseName, String semester, String csvFile) {
		Course course = createNewCourse(courseName, semester);
		ArrayList<Student> students = readCSV(csvFile);
		for(Student s : students)
		{
			Database.addStudentToCourse(s, course.getCourseId());
		}
		return course;
	}

	@Override
	public Course createNewCourseFromTemplateWithListOfStudents(String courseName, String semester, int courseId,
			String csvFile) {
		Course course = createNewCourseFromTemplate(courseName, semester, courseId);
		ArrayList<Student> students = readCSV(csvFile);
		for(Student s : students)
		{
			Database.addStudentToCourse(s, course.getCourseId()); 
		}
		return course;
	}
	
	private ArrayList<Student> readCSV(String csvFile)
	{
		//TODO : Finish this function
		//Reads csv file and returns list if student objects
		ArrayList<Student> students = null;
		return students;
		
	}

}
