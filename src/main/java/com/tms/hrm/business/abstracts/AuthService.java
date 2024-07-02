package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.dtos.EmployerRegisterDto;
import com.tms.hrm.entities.dtos.JobSeekerRegisterDto;
import com.tms.hrm.utils.result.Result;

public interface AuthService {

    Result registerEmployer(EmployerRegisterDto employerRegisterDto);

    Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto);

    Result verifyEmail(int userId, String activationCode);
}
