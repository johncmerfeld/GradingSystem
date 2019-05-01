package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import model.Course;
import model.Database;
import model.GradableCategory;
import model.GradableItem;
import model.Name;
import model.Student;

import com.opencsv.CSVReader;

public class CourseCreationController extends CourseSelectionController implements CourseCreation{
	
	public CourseCreationController()
	{}
	
	@Override
	public Course createNewCourse(String courseName, String semester) {
		Course course = new Course(courseName, semester);
		int id = Database.addCourse(course);
		course.setCourseId(id);
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
		//Reads csv file and returns list if student objects
		ArrayList<Student> students = new ArrayList<Student>();
		
		int BU_id;
		String fname, mname, lname, email;
		boolean isGradStudent;
		
		try {
			 CSVReader reader = new CSVReader(new FileReader(csvFile));
		     
			 String [] nextLine;
		     while ((nextLine = reader.readNext()) != null) {

		         // nextLine[] is an array of values from the line
		         BU_id = Integer.parseInt(nextLine[0]);
		         fname = nextLine[1];
		         mname = nextLine[2];
		         lname = nextLine[3];
		         email = nextLine[4];
		         isGradStudent = Boolean.parseBoolean(nextLine[5]);
		        
		         Name name = new Name(fname, mname, lname);
		         students.add(new Student(BU_id, name, email, isGradStudent));	        
		     }     
		     reader.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;	
	}

}
