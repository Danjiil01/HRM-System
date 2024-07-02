package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer findById(int id);

    Employer findByEmployerEmail(String email);
}
