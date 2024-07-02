package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.CityService;
import com.tms.hrm.dataaccess.abstracts.CityDao;
import com.tms.hrm.entities.concretes.City;
import com.tms.hrm.utils.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(
                this.cityDao.getOne(id)
        );
    }

    @Override
    public DataResult<City> getByName(String name) {
        return new SuccessDataResult<City>(
                this.cityDao.findByCityName(name)
        );
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(
                this.cityDao.findAll()
        );
    }

    @Override
    public Result add(City city) {
        if (!this.isCityExists(city.getCityName()).isSuccess()) {
            return new ErrorResult("City already exists ! ");
        }
        this.cityDao.save(city);
        return new SuccessResult("City added... ");
    }

    @Override
    public Result update(City city) {
        this.cityDao.save(city);
        return new SuccessResult("City updated... ");
    }

    @Override
    public Result delete(City city) {
        this.cityDao.delete(city);
        return new SuccessResult("City deleted... ");
    }

    public Result isCityExists(String name) {

        if (this.cityDao.findByCityName(name) != null) {
            return new ErrorResult();

        }
        return new SuccessResult();
    }
}
