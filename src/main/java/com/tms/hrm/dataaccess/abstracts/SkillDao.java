package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDao extends JpaRepository<Skill, Integer> {
    List<Skill> findAllByCv_Id(int id);
}
