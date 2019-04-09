So here's what's gonna happen:

Event happens on GUI
Object in GUI class sends request to the class object.
Class object calls the static Database class.


GradedItem item = Database.gradedItemQuery(**args**)




SELECT name, id FROM Students -> someFrontendObject

vs

SELECT * FROM Students -> someFrontendObject.getName() and .getId()

SELECT * FROM Students, Enrolled
WHERE Enrolled.courseId = query.courseId AND
Students.sid = Enrolled.sid




