package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.JobSeekerService;
import com.tms.hrm.entities.concretes.JobSeeker;
import com.tms.hrm.entities.dtos.JobSeekerCvDto;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/jobseeker")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @GetMapping("getCVById")
    public DataResult<JobSeekerCvDto> getCvById(@RequestParam int jobSeekerId) {

        return this.jobSeekerService.getDtoById(jobSeekerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.update(jobSeeker);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.delete(jobSeeker);
    }
}
