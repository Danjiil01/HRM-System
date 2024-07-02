package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.JobAdvertisementService;
import com.tms.hrm.dataaccess.abstracts.JobAdvertisementDao;
import com.tms.hrm.entities.concretes.JobAdvertisement;
import com.tms.hrm.utils.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findByIsActive()
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate() {
        Sort sort = Sort.by(Sort.Direction.DESC, "appealDeadline");

        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAll(sort)
        );
    }

    @Override
    public Result enableAdmin(int adminId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(adminId);
        if (!isJobAdvertisementExists(jobAdvertisement)) {

            return new ErrorResult("Job Advertisement doesn't exists");

        }

        jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Toggled");
    }

    @Override
    public Result changeVerifiedByAdmin(int adminId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(adminId);
        if (!isJobAdvertisementExists(jobAdvertisement)) {

            return new ErrorResult("Job Advertisement doesn't exists");

        }

        jobAdvertisement.setIsVerifiedByEmployees(true);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Verified by Employee");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advertisement added... ");
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advertisement updated... ");
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult("Job advertisement deleted... ");
    }

    private boolean isJobAdvertisementExists(JobAdvertisement jobAdvertisement) {

        if (jobAdvertisement == null) {
            return false;
        }
        return true;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.findAll()
        );
    }

}
