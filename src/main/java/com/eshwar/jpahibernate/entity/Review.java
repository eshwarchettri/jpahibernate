package com.eshwar.jpahibernate.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long Id;

    private String rating;
    private String description;
    @ManyToOne
    private Course course;



    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Review() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "description='" + description + '\'' +
                '}';
    }
}
