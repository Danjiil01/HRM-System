package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Employer;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface EmployerService {

    DataResult<Employer> getById(int id);

    DataResult<Employer> getByEmail(String email);

    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    Result update(Employer employer);

    Result delete(Employer employer);
}
