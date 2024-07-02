package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.EmployeesService;
import com.tms.hrm.entities.concretes.Employees;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        super();
        this.employeesService = employeesService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employees>> getAll() {
        return this.employeesService.getAll();
    }

    @GetMapping("getbyid")
    public DataResult<Employees> getById(@RequestParam("id") int employeesId) {
        return this.employeesService.getById(employeesId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employees employees) {
        return this.employeesService.add(employees);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employees employees) {
        return this.employeesService.update(employees);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employees employees) {
        return this.employeesService.delete(employees);
    }
}
