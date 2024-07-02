package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.JobAdvertisementService;
import com.tms.hrm.entities.concretes.JobAdvertisement;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


    @GetMapping("/getByIsActive")
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return this.jobAdvertisementService.getByIsActive();
    }


    @GetMapping("/getByAppealDeadline")
    public DataResult<List<JobAdvertisement>> getByAppealDeadline() {
        return this.jobAdvertisementService.getAllSortedByReleaseDate();
    }

    @GetMapping("/employeeVerified")
    public Result toggleVerifiedByEmployee(@RequestParam int adminId) {
        return this.jobAdvertisementService.enableAdmin(adminId);
    }

    @GetMapping("/toggleactive")
    public Result update(@RequestParam int adminId) {
        return this.jobAdvertisementService.changeVerifiedByAdmin(adminId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.update(jobAdvertisement);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }
}
