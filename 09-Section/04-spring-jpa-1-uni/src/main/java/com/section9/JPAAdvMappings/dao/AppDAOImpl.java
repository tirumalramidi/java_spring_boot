package com.section9.JPAAdvMappings.dao;

import com.section9.JPAAdvMappings.entity.Course;
import com.section9.JPAAdvMappings.entity.Instructor;
import com.section9.JPAAdvMappings.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructorById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;

    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courseList = instructor.getCourses();

        for(Course tempCourse: courseList){
            tempCourse.setInstructor(null);
        }


        entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);

    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        List<Course> courseList = query.getResultList();
        return courseList;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void update(Course course) {

        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int id) {

        Course course = entityManager.find(Course.class, id);
        return course;

    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course course) {

        entityManager.persist(course);

    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                "join fetch c.reviews " +
                "where c.id = :data" , Course.class);

        query.setParameter("data", id);

        Course course = query.getSingleResult();

        return course;

    }


}
