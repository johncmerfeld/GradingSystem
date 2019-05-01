# GradingSystem
Final project for Object-Oriented Development at Boston University

## To run:

  - Clone this repo

  - Download MySQL

For Mac users, 

```
brew install mysql 
```

is the easiest way to set up, and most closely mirrors our approach. 

  - Run the database setup script

```
bash setup.sh
```

If this script fails for some reason, you can follow its steps manually and adjust as needed. The most important step is to run the commands in the `sql` folder's `init.sql` script, which will create the application's supporting database.

  - Run the program

The username required to log in is "cpk@bu.edu" and the password is "123456", but the application should initialize with a valid username and password in place.

## Notes

  - The CSV file you use to load a class with students must look like this, without headers

```
77262,"Obi","Que","Markaman","oqm@bu.edu",0
85881,"Marmy","Xpert","Smarmy","marmysmarm@bu.edu",0
77124,"Helda","Umber","Plobium","plobium@bu.edu",1
99129,"Wowza","Absa","Bowsa","wowbow@bu.edu",1
71945,"Noelll","Lll","Llllll","noel@bu.edu",1
808,"Jay","Paulson","Walson","jpw@bu.edu",0
8081,"Jay","Paulson","WalsonWalson","jpww@bu.edu",0
```
That's BUID, first name, middle name, last name, email, and a boolean indicating whether the student is a graduate student.

