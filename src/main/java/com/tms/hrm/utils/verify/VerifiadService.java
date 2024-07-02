package com.tms.hrm.utils.verify;

public interface VerifiadService {

    void sendVerificationCode(String email);

    String codeGenerator();
}
