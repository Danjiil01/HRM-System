package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.CityService;
import com.tms.hrm.entities.concretes.City;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        super();
        this.cityService = cityService;
    }


    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("/getByCityId")
    public DataResult<City> getByCityId(@RequestParam("cityId") int cityId) {
        return this.cityService.getById(cityId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return this.cityService.add(city);
    }

    @PostMapping("/update")
    public Result update(@RequestBody City city) {
        return this.cityService.update(city);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody City city) {
        return this.cityService.delete(city);
    }
}
