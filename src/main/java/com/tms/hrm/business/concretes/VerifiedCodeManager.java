package com.tms.hrm.business.concretes;

import com.tms.hrm.business.abstracts.VerifiedCodeService;
import com.tms.hrm.dataaccess.abstracts.VerifiedCodeDao;
import com.tms.hrm.entities.concretes.VerifiedCode;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import com.tms.hrm.utils.result.SuccessDataResult;
import com.tms.hrm.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifiedCodeManager implements VerifiedCodeService {

    private VerifiedCodeDao verifiedCodeDao;

    @Autowired
    public VerifiedCodeManager(VerifiedCodeDao verifiedCodeDao) {
        super();
        this.verifiedCodeDao = verifiedCodeDao;
    }

    @Override
    public DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
        return new SuccessDataResult<VerifiedCode>(
                this.verifiedCodeDao.findByUserIdAndVerificationCode(userId, verificationCode)
        );
    }

    @Override
    public Result add(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code added... ");
    }

    @Override
    public Result update(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code updated... ");
    }

    @Override
    public Result delete(VerifiedCode verifiedCode) {
        this.verifiedCodeDao.save(verifiedCode);
        return new SuccessResult("Code deleted... ");
    }

}
