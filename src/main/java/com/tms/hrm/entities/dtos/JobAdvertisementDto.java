package com.tms.hrm.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    private String titleName;

    private String employerName;

    private int vacancies;

    private Date applicationDeadline;
}
