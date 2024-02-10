package com.section9.JPAAdvMappings;

import com.section9.JPAAdvMappings.dao.AppDAO;
import com.section9.JPAAdvMappings.dao.AppDAOImpl;
import com.section9.JPAAdvMappings.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.List;

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
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
//			deleteCourse(appDAO);
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
//			deleteCourseAndReviews(appDAO);

//		createCourseAndStudents(appDAO);
//		findCourseAndStudents(appDAO);
//		findStudentsAndCourse(appDAO);
//		addMoreCoursesForStudents(appDAO);

//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 4;

		System.out.println("Deleting the student");
		appDAO.deleteStudentById(id);
		System.out.println("Done");
	}

	private void addMoreCoursesForStudents(AppDAO appDAO) {
		int id = 4;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course("newCourse10");
		Course course2 = new Course("newCourse21");
		Course course3 = new Course("newCourse33");
		Course course4 = new Course("newCourse44");
		Course course5 = new Course("newCourse55");

		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);
		student.addCourse(course4);
		student.addCourse(course5);

		System.out.println("Student: "+ student);
		System.out.println("Courses added: "+ student.getCourses());
		appDAO.update(student);
		System.out.println("Done");

	}

	private void findStudentsAndCourse(AppDAO appDAO) {

		int id = 3;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println(student);
		System.out.println(student.getCourses());
		System.out.println("Done");

	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 11;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());
		System.out.println("Done");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("newCourse1");

		Student student1 = new Student("firstName1", "lastName1", "1firstNamelast@gmail.com");
		Student student2 = new Student("firstName2", "lastName2", "2firstNamelast@gmail.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("saving the course: "+ course);
		System.out.println("Associated students are: "+ course.getStudents());
		appDAO.save(course);
		System.out.println("Done");

	}



	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;
		System.out.println("deleting course id of:"+ id);
		appDAO.deleteCourseById(id);

		System.out.println("deleted");

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("newCourse");
		course.addReview(new Review("Great Course1"));
		course.addReview(new Review("Great Course2"));
		course.addReview(new Review("Great Course3"));

		System.out.println("Saving the course and reviews");
		appDAO.save(course);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done");


	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 16;
		System.out.println("Deleting the course based on the given id");
		appDAO.deleteCourseById(id);
		System.out.println("Deleted");
		System.out.println("Done");

	}

	private void updateCourse(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseById(id);
		System.out.println("Course with the given id is: "+ course);

		System.out.println("Updating ...");
		course.setTitle("Testing title");
		appDAO.update(course);
		System.out.println("Course After update is: "+ course);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Before update: "+ instructor);

		System.out.println("Updating");
		instructor.setLastName("Tester");

		appDAO.update(instructor);
		System.out.println("After update: "+ instructor);
		System.out.println("Done");



	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding the instructor with id:- "+ id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: "+ instructor);

		System.out.println();
		System.out.println("Finding courses for instructor id:-"+ id);
		List<Course> courseList = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courseList);
		System.out.println("Associated courses are: "+ instructor.getCourses());
		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor with the given id is:-" + instructor);
		System.out.println("Associated courses are:-" + instructor.getCourses());
		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("shiva", "reddy", "5shivareddy@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/shiva5", "watching 5phone");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Guitar1");
		Course course2 = new Course("Guitar2");

		instructor.add(course1);
		instructor.add(course2);


		System.out.println("List of courses: "+ instructor.getCourses());
		appDAO.save(instructor);
		System.out.println("Done");


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
		System.out.println("Deleting ");
		appDAO.deleteInstructorById(id);
		System.out.println("Done");

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
