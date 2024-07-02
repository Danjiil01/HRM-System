package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findById(int Id);

    JobSeeker findByNationalIdentity(String nationalIdentity);
}
