package com.section9.JPAAdvMappings;

import com.section9.JPAAdvMappings.dao.AppDAO;
import com.section9.JPAAdvMappings.dao.AppDAOImpl;
import com.section9.JPAAdvMappings.entity.Instructor;
import com.section9.JPAAdvMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAdvMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {

//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		appDAO.deleteInstructorDetailById(6);

	}

	private void findInstructorDetail(AppDAO appDAO) {

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);
		System.out.println(instructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;
		appDAO.deleteInstructorById(id);

	}

	private void findInstructor(AppDAO appDAO) {

		int id = 1;
		Instructor instructor = appDAO.findInstructorById(2);
//		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//
//		Instructor instructor = new Instructor("ravii1", "kumar1", "5ravikumar@gmail.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/6", "watching videos");

//		Instructor instructor = new Instructor("shiva2", "reddy2", "5shivareddy@gmail.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/shiva6", "watching phone");

		Instructor instructor = new Instructor("shiva3", "reddy3", "5shivareddy@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/shiva6", "watching phone");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);


	}

}
