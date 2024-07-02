package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.EmploymentTypeService;
import com.tms.hrm.entities.concretes.EmploymentType;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employmenttype")
public class EmploymentTypeController {

    private EmploymentTypeService employmentService;

    @Autowired
    public EmploymentTypeController(EmploymentTypeService employmentService) {
        super();
        this.employmentService = employmentService;
    }


    @GetMapping("/getall")
    public DataResult<List<EmploymentType>> getAll() {
        return this.employmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmploymentType employmentType) {
        return this.employmentService.add(employmentType);
    }
}
