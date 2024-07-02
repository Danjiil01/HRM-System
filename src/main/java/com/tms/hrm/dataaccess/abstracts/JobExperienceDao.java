package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> findByCv_Id(int id);
}
