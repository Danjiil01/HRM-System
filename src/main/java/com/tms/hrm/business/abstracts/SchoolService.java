package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.School;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface SchoolService {

    DataResult<List<School>> getAllByCvId(int cvId);

    DataResult<List<School>> getAll();

    Result add(School school);

    Result update(School school);

    Result delete(School school);
}
