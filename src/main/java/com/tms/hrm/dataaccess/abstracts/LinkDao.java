package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkDao extends JpaRepository<Link, Integer> {
    List<Link> findAllByCv_Id(int id);
}
