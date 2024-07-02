package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.AuthService;
import com.tms.hrm.business.abstracts.EmployerService;
import com.tms.hrm.business.abstracts.JobSeekerService;
import com.tms.hrm.business.abstracts.VerifiedCodeService;
import com.tms.hrm.entities.concretes.Employer;
import com.tms.hrm.entities.concretes.JobSeeker;
import com.tms.hrm.entities.concretes.VerifiedCode;
import com.tms.hrm.entities.dtos.EmployerRegisterDto;
import com.tms.hrm.entities.dtos.JobSeekerRegisterDto;
import com.tms.hrm.utils.result.ErrorResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessResult;
import com.tms.hrm.utils.verify.VerifiadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthManager implements AuthService {

    private JobSeekerService jobSeekerService;
    private EmployerService employerService;
    private VerifiedCodeService codeService;
    private VerifiadService verifiadService;
    private ModelMapper modelMapper;

    @Autowired
    public AuthManager(ModelMapper modelMapper, JobSeekerService jobSeekerService, EmployerService employerService,
                       VerifiadService verifiadService, VerifiedCodeService codeService) {

        this.modelMapper = modelMapper;
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        this.codeService = codeService;
        this.verifiadService = verifiadService;
    }

    @Override
    public Result registerEmployer(EmployerRegisterDto employerRegisterDto) {
        if (!checkIfEqualPasswordAndConfirmPassword(employerRegisterDto.getPassword(),
                employerRegisterDto.getConfirmPassword())) {
            return new ErrorResult("Your password or email is incorrect. Please try again...");
        }

        Employer employer = modelMapper.map(employerRegisterDto, Employer.class);
        var result = this.employerService.add(employer);
        System.out.println(result);

        if (result.isSuccess()) {
            this.generateVerificationCode(employer.getId());
        }

        return new ErrorResult("Error! Try again...");
    }

    @Override
    public Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto) {
        if (!checkIfEqualPasswordAndConfirmPassword(jobSeekerRegisterDto.getPassword(),
                jobSeekerRegisterDto.getConfirmedPassword())) {
            return new ErrorResult("Your password or email is incorrect. Please try again...");
        }

        JobSeeker jobSeeker = modelMapper.map(jobSeekerRegisterDto, JobSeeker.class);
        var result = this.jobSeekerService.add(jobSeeker);
        System.out.println(result);

        if (result.isSuccess()) {
            this.generateVerificationCode(jobSeeker.getId());
        }

        return new ErrorResult(result.getMessage());
    }

    @Override
    public Result verifyEmail(int userId, String activationCode) {

        var result = this.codeService.getByUserIdAndVerificationCode(userId, activationCode);

        if (!this.isVerificationCodeExist(userId, activationCode).isSuccess()
                || !this.isVerificationCodeActive(userId, activationCode).isSuccess()
                || !isExpired(userId, activationCode).isSuccess()) {
            return new ErrorResult("-");
        }
        if (!this.setCandidateActivationCode(userId).isSuccess()
                && !this.setEmployerActivationCode(userId).isSuccess()) {
            return new ErrorResult("User couldn't find ");
        }

        VerifiedCode verifiedCode = result.getData();
        verifiedCode.setConfirmedDate(LocalDate.now());
        verifiedCode.setIsActivate(true);
        this.codeService.update(verifiedCode);

        return new SuccessResult("Verified !");
    }

    private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            return false;
        }

        return true;
    }

    private Result setEmployerActivationCode(int userId) {

        if (this.employerService.getById(userId).getData() != null) {

            Employer employer = this.employerService.getById(userId).getData();

            employer.setIsEmailVerified(true);

            this.employerService.update(employer);

            return new SuccessResult();
        }

        return new ErrorResult();
    }

    private Result setCandidateActivationCode(int userId) {
        if (this.jobSeekerService.getById(userId).getData() != null) {

            JobSeeker jobSeeker = this.jobSeekerService.getById(userId).getData();

            jobSeeker.setIsEmailVerified(true);

            this.jobSeekerService.update(jobSeeker);

            return new SuccessResult();
        }

        return new ErrorResult();
    }

    private Result isVerificationCodeExist(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData() == null) {
            return new ErrorResult("Verification Code is wrong !");
        }
        return new SuccessResult();

    }

    private Result isVerificationCodeActive(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getIsActivate()) {

            return new ErrorResult("Verification Code is already active");
        }
        return new SuccessResult();
    }

    private Result isExpired(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getExpiredDate()
                .isBefore(LocalDate.now())) {

            return new ErrorResult("Verification Code is Expired");
        }
        return new SuccessResult();
    }

    private Result generateVerificationCode(int userId) {
        String code = this.verifiadService.codeGenerator();
        this.verifiadService.sendVerificationCode(code);
        VerifiedCode verifiedCode = new VerifiedCode(userId, code, LocalDate.now().plusDays(1));
        this.codeService.add(verifiedCode);
        return new SuccessResult("User Registered !");
    }
}
