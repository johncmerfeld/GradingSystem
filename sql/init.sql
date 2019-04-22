CREATE DATABASE gradingsystem;
USE gradingsystem;

CREATE TABLE Course(
	courseId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	courseName VARCHAR(50),
	semester VARCHAR(30),
	isActive BOOLEAN);

CREATE TABLE StudentType(
        studentTypeId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        studentType VARCHAR(30));

CREATE TABLE Student(
	studentId INT NOT NULL PRIMARY KEY, -- BUID
	firstName VARCHAR(30),
	middleInitial CHAR,
	lastName VARCHAR(30),
	email VARCHAR(30),
	studentType INT,
	FOREIGN KEY (studentType) REFERENCES StudentType(studentTypeId) );

CREATE TABLE Enrolled(
	courseId INT,
	studentId INT,
	notes TEXT,
	FOREIGN KEY (courseId) REFERENCES Course(courseId),
	FOREIGN KEY (studentId) REFERENCES Student(studentId) );

CREATE TABLE Category(
	categoryId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	categoryName VARCHAR(30),
	courseId INT,
	percentageWeight DOUBLE,
	FOREIGN KEY (courseId) REFERENCES Course(courseId) );

CREATE TABLE ScoringMethod(
        scoringMethodId INT PRIMARY KEY,
        scoringMethod VARCHAR(30));

CREATE TABLE GradedItem(
	gradedItemId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	gradedItemName VARCHAR(30),
	categoryId INT,
	maxPoints DOUBLE,
	scoringMethodId INT,
	percentageWeight DOUBLE,
	include BOOLEAN,
	FOREIGN KEY (categoryId) REFERENCES Category(categoryId),
	FOREIGN KEY (scoringMethodId) REFERENCES ScoringMethod(scoringMethodId) );

CREATE TABLE StudentGrade(
	studentId INT,
	gradedItemId INT,
	score DOUBLE,
	notes TEXT,
	FOREIGN KEY (studentId) REFERENCES Student(studentId),
	FOREIGN KEY (gradedItemId) REFERENCES GradedItem(gradedItemId) );
