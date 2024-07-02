package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {
    List<School> findAllByCv_Id(int id);
}
