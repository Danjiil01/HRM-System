package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.SchoolService;
import com.tms.hrm.dataaccess.abstracts.SchoolDao;
import com.tms.hrm.entities.concretes.School;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        super();
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School added... ");
    }

    @Override
    public Result update(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School updated... ");
    }

    @Override
    public Result delete(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School deleted... ");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAll()
        );
    }
}
