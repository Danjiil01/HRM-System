package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.PreliminaryExplanationService;
import com.tms.hrm.dataaccess.abstracts.PreliminaryExplanationDao;
import com.tms.hrm.entities.concretes.PreliminaryExplanation;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreliminaryExplanationManager implements PreliminaryExplanationService {

    private PreliminaryExplanationDao preliminaryExplanationDao;

    @Autowired
    public PreliminaryExplanationManager(PreliminaryExplanationDao preliminaryExplanationDao) {
        super();
        this.preliminaryExplanationDao = preliminaryExplanationDao;
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationDao.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation added... ");
    }

    @Override
    public Result update(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation updated... ");
    }

    @Override
    public Result delete(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationDao.delete(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation deleted... ");
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAll() {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationDao.findAll()
        );
    }
}
