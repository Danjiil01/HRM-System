package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Employees;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface EmployeesService {
    DataResult<Employees> getById(int employeesId);

    DataResult<List<Employees>> getAll();

    Result add(Employees employees);

    Result update(Employees employees);

    Result delete(Employees employees);
}
