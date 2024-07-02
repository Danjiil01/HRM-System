package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.PreliminaryExplanationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PreliminaryExplanationController {
    private PreliminaryExplanationService preliminaryExplanationService;

    @Autowired
    public PreliminaryExplanationController(PreliminaryExplanationService preliminaryExplanationService){
         super();
         this.preliminaryExplanationService=preliminaryExplanationService;
     }
}
