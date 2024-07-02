package com.tms.hrm.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerRegisterDto {

    private String email;
    private String password;
    private String confirmedPassword;
    private String firstName;
    private String lastName;
    private String identificationNumber;
    private LocalDate dateOfBirth;
}
