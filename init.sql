CREATE DATABASE gradingsystem;
USE gradingsystem;

CREATE TABLE Course(
	courseId INT PRIMARY KEY,
	courseName VARCHAR(50) NOT NULL,
	semester VARCHAR(30) NOT NULL,
	isActive BOOLEAN);

CREATE TABLE Student(
	studentId INT PRIMARY KEY, -- BUID
	firstName VARCHAR(30),
	middleInitial CHAR,
	lastName VARCHAR(30),
	email VARCHAR(30),
	isGradStudent BOOLEAN);

CREATE TABLE Enrolled(
	courseId INT,
	studentId INT,
	notes VARCHAR(255),
	FOREIGN KEY (courseId) REFERENCES Course(courseId),
	FOREIGN KEY (studentId) REFERENCES Student(studentId) );

CREATE TABLE Category(
	categoryId INT,
	categoryName VARCHAR(30),
	courseId INT,
	percentageWeight FLOAT,
	FOREIGN KEY (courseId) REFERENCES Course(courseId) );
	

CREATE TABLE GradedItems(
	gradedItemId INT,
	gradedItemName VARCHAR(30),
	categoryId INT,
	maxPoints FLOAT,
	deductionScoring BOOLEAN,
	percentageWeight FLOAT,
	FOREIGN KEY (categoryId) REFERENCES Category(categoryId) );

CREATE TABLE StudentGrade(
	studentId INT,
	gradedItemId INT,
	score FLOAT,
	notes VARCHAR(255),
	FOREIGN KEY (studentId) REFERENCES Student(studentId),
	FOREIGN KEY (gradedItemId) REFERENCES GradedItem(gradedItemId) );
