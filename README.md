# Student_information_Management
This is a simple Student Record Management System developed in Java that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in an SQLite database.

The application provides a command-line interface to:
1. Add new student records
2. View all students
3. Update existing student details
4. Delete student records

Features
@ Uses SQLite as the database backend for persistent storage.
@ Supports basic student details: ID, Name, Age.
@ Simple console menu-driven interface.
@ Implements database connection, table creation, and CRUD queries using JDBC.
@ Demonstrates best practices with prepared statements to prevent SQL injection.

# Setup Instructions
1. Clone or download the project
2. Add SQLite JDBC Driver to your project
3. Download the SQLite JDBC driver from https://github.com/xerial/sqlite-jdbc/releases and add the JAR file to your   project classpath.
4. Compile and run
5. Compile and run the Main.java class to start the application
6. Interact with the menu
7. Follow the on-screen prompts to add, view, update, or delete student records.

# Code Structure

Student.java: Model class representing a student entity.

Student_Database.java: Handles SQLite database connection and CRUD operations.

Main.java: Main class with the user interface loop for menu-driven interaction.
