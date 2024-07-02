package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.EmployeesService;
import com.tms.hrm.dataaccess.abstracts.EmployeesDao;
import com.tms.hrm.entities.concretes.Employees;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesManager implements EmployeesService {

    private EmployeesDao employeesDao;

    @Autowired
    public EmployeesManager(EmployeesDao employeesDao) {
        super();
        this.employeesDao = employeesDao;
    }

    @Override
    public DataResult<Employees> getById(int employeesId) {
        return new SuccessDataResult<Employees>(
                this.employeesDao.findById(employeesId)
        );
    }

    @Override
    public DataResult<List<Employees>> getAll() {
        return new SuccessDataResult<List<Employees>>(
                this.employeesDao.findAll()
        );
    }

    @Override
    public Result add(Employees employees) {
        this.employeesDao.save(employees);
        return new SuccessResult("Employees added... ");
    }

    @Override
    public Result update(Employees employees) {
        this.employeesDao.save(employees);
        return new SuccessResult("Employees updated... ");
    }

    @Override
    public Result delete(Employees employees) {
        this.employeesDao.delete(employees);
        return new SuccessResult("Employees deleted... ");
    }
}
