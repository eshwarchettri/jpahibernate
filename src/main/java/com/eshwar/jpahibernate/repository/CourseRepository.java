package com.eshwar.jpahibernate.repository;

import com.eshwar.jpahibernate.entity.Course;
import com.eshwar.jpahibernate.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void playWithEntityManager() {
        Course course = new Course("Spring with Jpa");
        entityManager.persist(course); // Save Data to Data base
        entityManager.flush(); // changes upto that point will be sent to database

        Course course1 = findById(1001L);
        course1.setName("Hibernate Test Update");
        entityManager.persist(course1);
        entityManager.flush();

        entityManager.detach(course); //  

        entityManager.clear(); // it will clear the entity manager and no entities will be tracked
        course.setName("Spring with jpa - Updated");
        log.info("course --> {}", course);

    }

    public void addReviewsToCourse(Long courseId, List<Review> reviews) {
        Course course = entityManager.find(Course.class, courseId);
        reviews.forEach(review -> {
            course.addReviews(review);
            review.setCourse(course);
            entityManager.persist(review);
        });
    }
}
