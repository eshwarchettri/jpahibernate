package com.eshwar.jpahibernate.repository;

import com.eshwar.jpahibernate.entity.Course;
import com.eshwar.jpahibernate.entity.Passport;
import com.eshwar.jpahibernate.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);
        Student student = new Student("mike");
        student.setPassport(passport);
        entityManager.persist(student);

    }

    public void saveStudentAndCourse(Student student, Course course) {
        entityManager.persist(student);
        entityManager.persist(course);
        student.addCourse(course);
        course.addStudent(student);
        entityManager.persist(student);

    }
}
