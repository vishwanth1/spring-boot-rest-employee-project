package com.vishwa.employee.springproject.dao;

import com.vishwa.employee.springproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;
    public EmployeeDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("From Employee", Employee.class);

        List<Employee> result = query.getResultList();

        return result;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeDetails = entityManager.merge(employee);
        return employeeDetails;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
