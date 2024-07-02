package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.JobSeeker;
import com.tms.hrm.entities.dtos.JobSeekerCvDto;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface JobSeekerService {

    DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity);

    DataResult<JobSeeker> getById(int jobSeekerId);

    DataResult<JobSeekerCvDto> getDtoById(int jobSeekerId);

    DataResult<List<JobSeeker>> getAll();

    Result add(JobSeeker jobSeeker);

    Result update(JobSeeker jobSeeker);

    Result delete(JobSeeker jobSeeker);
}
