package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.PreliminaryExplanation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreliminaryExplanationDao extends JpaRepository<PreliminaryExplanation, Integer> {
    List<PreliminaryExplanation> findAllByCv_Id(int id);
}
