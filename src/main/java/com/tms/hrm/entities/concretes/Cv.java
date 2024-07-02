package com.tms.hrm.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "cv")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "github_link")
    private String githubLink;

    @OneToMany(mappedBy = "cv")
    private List<School> schools;

    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv")
    private List<Language> languages;

    @OneToMany(mappedBy = "cv")
    private List<Link> links;

    @OneToMany(mappedBy = "cv")
    private List<PreliminaryExplanation> preliminaryExplanations;

    @OneToMany(mappedBy = "cv")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
