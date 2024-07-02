package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.SchoolService;
import com.tms.hrm.entities.concretes.School;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @PostMapping("/update")
    public Result update(@RequestBody School school) {
        return this.schoolService.update(school);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody School school) {
        return this.schoolService.delete(school);
    }
}
