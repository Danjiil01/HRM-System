package com.tms.hrm.business.abstracts;

import com.tms.hrm.entities.concretes.VerifiedCode;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;

public interface VerifiedCodeService {

    DataResult<VerifiedCode> getByUserIdAndVerificationCode(int userId, String verificationCode);

    Result add(VerifiedCode verifiedCode);

    Result update(VerifiedCode verifiedCode);

    Result delete(VerifiedCode verifiedCode);
}
