package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.LanguageService;
import com.tms.hrm.entities.concretes.Language;
import com.tms.hrm.utils.result.DataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid Language language) {
        return this.languageService.add(language);
    }


    @PostMapping("/update")
    public Result update(@RequestBody Language language) {
        return this.languageService.update(language);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return this.languageService.delete(language);
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getall(@RequestParam int candidateId) {
        return this.languageService.getAllByCvId(candidateId);
    }
}
