package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.City;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface CityService {

    DataResult<City> getById(int id);

    DataResult<City> getByName(String name);

    DataResult<List<City>> getAll();

    Result add(City city);

    Result update(City city);

    Result delete(City city);
}
