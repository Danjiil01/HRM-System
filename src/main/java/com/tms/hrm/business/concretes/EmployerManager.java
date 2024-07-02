package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.EmployerService;
import com.tms.hrm.dataaccess.abstracts.EmployerDao;
import com.tms.hrm.entities.concretes.Employer;
import com.tms.hrm.utils.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(
                this.employerDao.findById(id)
        );
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(
                this.employerDao.findByEmployerEmail(email)
        );
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(
                this.employerDao.findAll()
        );
    }

    @Override
    public Result add(Employer employer) {
        if (!this.checkIfEmailExists(employer.getEmployerEmail())) {
            return new ErrorResult("Email already exist ! ");
        }

        if(!this.checkIfEqualEmailAndDomain(employer.getEmployerEmail(),employer.getEmployerWebsite())) {
            return new ErrorResult("Invalid mail address ! ");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Employer added... ");
    }

    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer updated... ");
    }

    @Override
    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult("Employer deleted... ");
    }

    private boolean checkIfEmailExists(String email) {
        if (this.employerDao.findByEmployerEmail(email) != null) {
            return false;
        }
        return true;

    }

    private boolean checkIfEqualEmailAndDomain(String email, String website) {
        String[] emailArr = email.split("@", 2);
        String domain = website.substring(4, website.length());
        if (emailArr[1].equals(domain)) {
            return true;
        }

        return false;
    }
}
