package com.eshwar.jpahibernate.repository;

import com.eshwar.jpahibernate.JpaHibernateApplication;
import com.eshwar.jpahibernate.entity.Passport;
import com.eshwar.jpahibernate.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class StudentRepositoryTest {
Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional // Transactional will help to maintain the Hibernate session through out the method, If we dont use
                   // Transactional annotation the session will be killed after fetching the Student details then when
                   //  we try to get Passport details we will get no session error
    public void getStudentWithPassport() {
        Student student = studentRepository.findById(2001L);
        logger.info("Student --> {}", student);
        logger.info("Passport --> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void getPassportWithStudent() {
        Passport passport = entityManager.find(Passport.class, 3001L);
        logger.info("Passort --> {}", passport);
        logger.info("Student --> {}", passport.getStudent());
    }

    @Test
    @Transactional // When we use Transactional annotation we deal with Persistence Context, Persistence Conext
                   // is a place where all the entities which we are operating up on are being stored, Persistence Context
                  // starts at the beginning of the transaction and killed at end of the transaction, only after the entire
                 // tarnsactional is completed data will be sent to database, the way we intarct with Persistance Context
                // is with the help of EntityManager
                // In hibernate terminology session means Persistence Context
                // In JPA we use EntityManager to talk with Persistence Context
                // EntityManager is Interface to PersistenceContext
                // PersistenceContext has ability to access the Database as well
    public void someTest() {
        //Database operation1 -- Retrieve student
        Student student = entityManager.find(Student.class, 2001l);
        //Persistence Context (student)

        // DataBase opetion 2 -- Retrive passport

        Passport passport = student.getPassport();
        //Persistence Context (student, passport)

        //DB operation 3 -- set passport number
        passport.setNumber("E12345676");
        // Persistence Context (student, passport ++)

        //DB operation 4 -- set student name
        student.setName("Ranga Updated");
        // Persistence Context (student ++, passport ++ )
    }
}