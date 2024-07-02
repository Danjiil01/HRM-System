package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.EmployerService;
import com.tms.hrm.entities.concretes.Employer;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employer")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employer employer) {
        return this.employerService.update(employer);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer) {
        return this.employerService.delete(employer);
    }
}
