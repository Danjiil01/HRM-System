package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.SkillService;
import com.tms.hrm.entities.concretes.Skill;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/skill")
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        super();
        this.skillService = skillService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Skill skill) {
        return this.skillService.add(skill);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return this.skillService.update(skill);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Skill skill) {
        return this.skillService.delete(skill);
    }
}
