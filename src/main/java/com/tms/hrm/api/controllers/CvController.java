package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.CvService;
import com.tms.hrm.utils.result.ErrorDataResult;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(name = "/api/cv")
@CrossOrigin
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.cvService.getAll());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {
        return this.cvService.add(cv);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Cv cv) {
        return this.cvService.delete(cv);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody Cv cv) {
        return this.cvService.delete(cv);
    }

    @GetMapping("/getallbyjobseekerid")
    public ResponseEntity<?> getAllByJobSeekerId(@RequestParam(name = "id") int id) {
        return ResponseEntity.ok(this.cvService.getAllByJobSeekerId(id));
    }

    @PostMapping("/uploadphoto")
    public ResponseEntity<?> uploadPhoto(@RequestParam(name = "id") Integer id,
                                         @RequestBody MultipartFile file) {
        return ResponseEntity.ok(this.cvService.uploadImage(id, file));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(validationErrors, "Validation Errors");
    }
}
