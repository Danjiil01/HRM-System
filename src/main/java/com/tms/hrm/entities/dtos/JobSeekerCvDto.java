package com.tms.hrm.entities.dtos;

import com.tms.hrm.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvDto {

    public JobSeeker jobSeeker;
    public List<School> schools;
    public List<Skill> skills;
    public List<Link> links;
    public List<Language> languages;
    public List<JobExperience> jobExperiences;
    public List<PreliminaryExplanation> preliminaryExplanations;
}
