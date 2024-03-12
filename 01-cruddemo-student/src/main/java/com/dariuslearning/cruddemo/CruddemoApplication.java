package com.dariuslearning.cruddemo;

import com.dariuslearning.cruddemo.dao.StudentDAO;
import com.dariuslearning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted + " students deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id of " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student by pk (id)
		int theId = 4;
		System.out.println("Getting student with id: " + theId);
		Student tempStudent = studentDAO.findById(theId);
		// change first name to "Scooby"
		System.out.println("Updating student...");
		tempStudent.setFirstName("Mickey");
		// update student
		studentDAO.update(tempStudent);
		//display updated student
		System.out.println("Updated: " + tempStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Mouse");
		//display students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Mickey","Mouse", "mickeymouse@hadob.mk");
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Student id ..." + theId);
		// retrieve student based on pk (id)
		System.out.println("Retrieving student by id...");
		Student myStudent = studentDAO.findById(theId);
		// display student
		System.out.println("Found student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("Ion","Doe","johndoe@gmail.com");
		Student tempStudent2 = new Student("Maria","Ioana","MariaIoana@gmail.com");
		Student tempStudent3 = new Student("Bonita","Ramona","ramonabonita@gmail.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Darius","Zdroba","dariusgms@gmail.com");
		// save student object
		System.out.println("Saving the student object ...");
		studentDAO.save(tempStudent);
		// display id of saved student
		System.out.println("Saved student with generated id: " + tempStudent.getId());
	}
}
