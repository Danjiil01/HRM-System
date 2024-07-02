package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {

}
