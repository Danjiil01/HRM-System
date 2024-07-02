package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.JobsService;
import com.tms.hrm.entities.concretes.Jobs;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/jobs")
public class JobsController {

    private JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        super();
        this.jobsService = jobsService;
    }


    @GetMapping("/getall")
    public DataResult<List<Jobs>> getAll() {
        return this.jobsService.getAll();
    }


    @PostMapping("/add")
    public Result registerCandidate(@RequestBody Jobs jobs) {
        return this.jobsService.add(jobs);
    }

    @GetMapping("/getByJobTitleId")
    public DataResult<Jobs> getByCityId(@RequestParam("jobsId") int jobsId) {
        return this.jobsService.getJobsId(jobsId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Jobs jobs) {
        return this.jobsService.update(jobs);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Jobs jobs) {
        return this.jobsService.delete(jobs);
    }
}
