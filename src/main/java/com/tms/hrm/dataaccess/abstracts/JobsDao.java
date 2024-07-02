package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsDao extends JpaRepository<Jobs, Integer> {
    Jobs findByExplanation(String explanation);
}
