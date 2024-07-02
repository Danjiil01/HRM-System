package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
    City findByCityName(String name);

    City findById(int id);
}
