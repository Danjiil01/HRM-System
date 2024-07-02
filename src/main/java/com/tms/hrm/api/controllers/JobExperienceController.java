package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.JobExperienceService;
import com.tms.hrm.entities.concretes.JobExperience;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.update(jobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobExperience jobExperience) {

        return this.jobExperienceService.delete(jobExperience);
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }
}
