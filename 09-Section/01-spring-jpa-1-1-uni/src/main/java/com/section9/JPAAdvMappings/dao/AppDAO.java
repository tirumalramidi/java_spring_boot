package com.section9.JPAAdvMappings.dao;

import com.section9.JPAAdvMappings.entity.Instructor;
import com.section9.JPAAdvMappings.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

}
