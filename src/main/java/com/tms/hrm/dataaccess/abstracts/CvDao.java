package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> findByJobSeeker_id(int id);
}
