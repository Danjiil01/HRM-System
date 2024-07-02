package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.EmploymentType;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface EmploymentTypeService {

    DataResult<List<EmploymentType>> getAll();

    Result add(EmploymentType employmentType);
}
