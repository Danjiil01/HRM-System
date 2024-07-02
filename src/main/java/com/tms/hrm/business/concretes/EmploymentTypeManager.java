package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.EmploymentTypeService;
import com.tms.hrm.dataaccess.abstracts.EmploymentTypeDao;
import com.tms.hrm.entities.concretes.EmploymentType;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {

    private EmploymentTypeDao employmentDao;

    public EmploymentTypeManager(EmploymentTypeDao employmentDao) {
        super();
        this.employmentDao = employmentDao;
    }

    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<List<EmploymentType>>(
                this.employmentDao.findAll()
        );
    }

    @Override
    public Result add(EmploymentType employmentType) {
        this.employmentDao.save(employmentType);
        return new SuccessResult("Employment type added... ");
    }

}
