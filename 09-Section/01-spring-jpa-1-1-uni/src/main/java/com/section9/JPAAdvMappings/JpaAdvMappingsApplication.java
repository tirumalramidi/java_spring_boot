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
			deleteInstructor(appDAO);

		};
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

//		Instructor instructor = new Instructor("ravii", "kumar", "ravikumar@gmail.com");
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/", "watching videos");

		Instructor instructor = new Instructor("shiva", "reddy", "shivareddy@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/shiva", "watching phone");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);


	}

}
