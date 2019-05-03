# GradingSystem
Final project for Object-Oriented Development at Boston University. A fully-functional end-to-end grading system for Professor Papadakis-Kanaris.

## To run:

  - Clone this repo

  - Download MySQL

For Mac users, 

```
brew install mysql 
```

is the easiest way to set up, and most closely mirrors our approach. **Please note**: the application assumes you are running as the root user and have a blank MySQL password. **What if not??**

  - Run the database setup script

```
bash setup.sh
```

If this script fails for some reason, you can follow its steps manually and adjust as needed. The most important step is to run the commands in the `sql` folder's `init.sql` script, which will create the application's supporting database.

  - Run the program

To run, simply execute the JAR file:

```
java -jar gradingsystem.jar
```

The username required to log in is "cpk@bu.edu" and the password is "123456", but the application should initialize with a valid username and password in place.

## Notes

  - The CSV file you use to load a class with students must look like this, without headers

```
100,Stone,Raymond,Browning,ut.pellentesque.eget@consequat.edu,0
101,Yetta,Rooney,Whitney,nibh.Aliquam.ornare@ornareIn.edu,1
102,Macon,Nicole,Wolfe,ultricies@loremauctor.ca,1
103,Flynn,Clarke,Cannon,malesuada.Integer.id@semperauctorMauris.edu,1
104,Dakota,Nash,Bauer,ridiculus@porttitorinterdum.net,1
```
That's BUID, first name, middle name, last name, email, and a boolean indicating whether the student is a graduate student.

