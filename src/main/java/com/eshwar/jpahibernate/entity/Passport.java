package com.eshwar.jpahibernate.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String number;



    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") // we use mappedBy in non owning side of the table,
    // if we don't mappedBy the duplicate data will be created for eg: STUDENT_ID column will be created in PASSPORT table
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return Id;
    }

    public String getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    protected Passport() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                '}';
    }
}
