package com.eshwar.jpahibernate.repository;

import com.eshwar.jpahibernate.entity.inheritance.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> findAllEmployee() {
        return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
    }
}
