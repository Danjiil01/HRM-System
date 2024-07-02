package com.tms.hrm.dataaccess.abstracts;

import com.tms.hrm.entities.concretes.VerifiedCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifiedCodeDao extends JpaRepository<VerifiedCode, Integer> {
    VerifiedCode findByUserIdAndVerificationCode(int userId, String verificationCode);
}
