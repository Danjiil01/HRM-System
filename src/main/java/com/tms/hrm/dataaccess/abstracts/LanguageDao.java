package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    List<Language> findAllByCv_Id(int id);
}
