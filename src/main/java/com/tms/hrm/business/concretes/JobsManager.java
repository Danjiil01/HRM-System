package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.JobsService;
import com.tms.hrm.dataaccess.abstracts.JobsDao;
import com.tms.hrm.entities.concretes.Jobs;
import com.tms.hrm.utils.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsManager implements JobsService {

    private JobsDao jobsDao;

    @Autowired
    public JobsManager(JobsDao jobsDao) {
        super();
        this.jobsDao = jobsDao;
    }

    @Override
    public DataResult<Jobs> getByExplanation(String explanation) {
        return new SuccessDataResult<Jobs>(
                this.jobsDao.findByExplanation(explanation)
        );
    }

    @Override
    public DataResult<Jobs> getJobsId(int jobsId) {
        return new SuccessDataResult<Jobs>(
                this.jobsDao.getOne(jobsId)
        );
    }

    @Override
    public DataResult<List<Jobs>> getAll() {
        return new SuccessDataResult<List<Jobs>>(
                this.jobsDao.findAll()
        );
    }

    @Override
    public Result add(Jobs jobs) {
        if (!this.isTitleExist(jobs.getExplanation())) {

            return new ErrorResult("Jobs exist ! ");
        }

        this.jobsDao.save(jobs);
        return new SuccessResult("Jobs added... ");
    }

    @Override
    public Result update(Jobs jobs) {
        this.jobsDao.save(jobs);
        return new SuccessResult("Jobs updated... ");
    }

    @Override
    public Result delete(Jobs jobs) {
        this.jobsDao.delete(jobs);
        return new SuccessResult("Jobs deleted... ");
    }

    private boolean isTitleExist(String explanation) {
        if (this.jobsDao.findByExplanation(explanation) != null) {
            return false;
        }
        return true;

    }
}
