package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.JobExperience;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface JobExperienceService {

    DataResult<List<JobExperience>> getAllByCvId(int cvId);

    DataResult<List<JobExperience>> getAll();

    Result add(JobExperience jobExperinence);

    Result update(JobExperience jobExperinence);

    Result delete(JobExperience jobExperinence);
}
