package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.Jobs;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface JobsService {

    DataResult<Jobs> getByExplanation(String explanation);

    DataResult<Jobs> getJobsId(int jobsId);

    DataResult<List<Jobs>> getAll();

    Result add(Jobs jobs);

    Result update(Jobs jobs);

    Result delete(Jobs jobs);
}
