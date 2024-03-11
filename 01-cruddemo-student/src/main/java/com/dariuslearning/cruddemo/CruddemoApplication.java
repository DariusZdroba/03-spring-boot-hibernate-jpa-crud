package com.dariuslearning.cruddemo;

import com.dariuslearning.cruddemo.dao.StudentDAO;
import com.dariuslearning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			creatMultipleStudents(studentDAO);
		};
	}

	private void creatMultipleStudents(StudentDAO studentDAO) {
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
