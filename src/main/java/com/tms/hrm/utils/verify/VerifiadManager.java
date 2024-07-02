package com.tms.hrm.utils.verify;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerifiadManager implements VerifiadService {

    @Override
    public void sendVerificationCode(String email) {

        UUID uuid = UUID.randomUUID();
        String verificatitionLink = "https://hrmsverifiademail/" + uuid.toString();
    }

    @Override
    public String codeGenerator() {

        UUID uuid = UUID.randomUUID();
        String verificationCode = uuid.toString();
        return verificationCode;
    }

}
