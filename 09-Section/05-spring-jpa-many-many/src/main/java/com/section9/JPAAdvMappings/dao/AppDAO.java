package com.section9.JPAAdvMappings.dao;

import com.section9.JPAAdvMappings.entity.Course;
import com.section9.JPAAdvMappings.entity.Instructor;
import com.section9.JPAAdvMappings.entity.InstructorDetail;
import com.section9.JPAAdvMappings.entity.Student;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);

}
