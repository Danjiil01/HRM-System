package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.JobAdvertisement;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getByIsActive();

    DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();

    DataResult<List<JobAdvertisement>> getAll();

    Result enableAdmin(int adminId);

    Result changeVerifiedByAdmin(int adminId);

    Result add(JobAdvertisement jobAdvertisement);

    Result update(JobAdvertisement jobAdvertisement);

    Result delete(JobAdvertisement jobAdvertisement);
}
