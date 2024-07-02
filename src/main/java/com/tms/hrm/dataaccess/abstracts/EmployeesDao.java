package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {
    Employees findById(int id);
}
