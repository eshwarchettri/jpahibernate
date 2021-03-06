package com.eshwar.jpahibernate;

import com.eshwar.jpahibernate.entity.Course;
import com.eshwar.jpahibernate.entity.Review;
import com.eshwar.jpahibernate.entity.Student;
import com.eshwar.jpahibernate.entity.inheritance.FullTimeEmployee;
import com.eshwar.jpahibernate.entity.inheritance.PartTimeEmployee;
import com.eshwar.jpahibernate.repository.CourseRepository;
import com.eshwar.jpahibernate.repository.EmployeeRepository;
import com.eshwar.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {
private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepository.saveStudentWithPassport();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("4", "excellint work"));
//        reviews.add(new Review("5", "welldone"));
//        courseRepository.addReviewsToCourse(1003L, reviews);

//        Student student = studentRepository.findById(2001L);
//        logger.info("student -> {}", student);
//        logger.info("course -> {}", student.getCourses());

//        studentRepository.saveStudentAndCourse(new Student("Eshwar"), new Course("Microservice in 100 steps"));

        employeeRepository.insert(new PartTimeEmployee("Jack", new BigDecimal("50")));
        employeeRepository.insert(new FullTimeEmployee("Jill", new BigDecimal("1150")));

        logger.info("Employee --> {}", employeeRepository.findAllEmployee());
    }
}
