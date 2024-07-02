package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.JobExperienceService;
import com.tms.hrm.dataaccess.abstracts.JobExperienceDao;
import com.tms.hrm.entities.concretes.JobExperience;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    public JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        super();
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAllByCvId(int cvId) {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceDao.findByCv_Id(cvId)
        );
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceDao.findAll()
        );
    }

    @Override
    public Result add(JobExperience jobExperinence) {
        this.jobExperienceDao.save(jobExperinence);
        return new SuccessResult("Job experience added... ");
    }

    @Override
    public Result update(JobExperience jobExperinence) {
        this.jobExperienceDao.save(jobExperinence);
        return new SuccessResult("Job experience updated... ");
    }

    @Override
    public Result delete(JobExperience jobExperinence) {
        this.jobExperienceDao.delete(jobExperinence);
        return new SuccessResult("Job experience deleted... ");
    }
}
