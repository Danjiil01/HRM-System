package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    @Query("From JobAdvertisement where isActive=true")
    List<JobAdvertisement> findByIsActive();

    JobAdvertisement findById(int advertisement);
}
