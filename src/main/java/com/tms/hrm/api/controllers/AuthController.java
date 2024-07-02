package com.tms.hrm.api.controllers;

import com.tms.hrm.business.abstracts.AuthService;
import com.tms.hrm.entities.dtos.EmployerRegisterDto;
import com.tms.hrm.entities.dtos.JobSeekerRegisterDto;
import com.tms.hrm.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/jobseekerregister")
    public Result jobSeekerRegister(@RequestBody JobSeekerRegisterDto jobSeekerRegisterDto) {
        return this.authService.registerJobSeeker(jobSeekerRegisterDto);
    }

    @PostMapping("/employerregister")
    public Result registerEmployer(@RequestBody EmployerRegisterDto employerRegisterDto) {
        return this.authService.registerEmployer(employerRegisterDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String verificationCode) {
        return this.authService.verifyEmail(userId, verificationCode);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation error. Try again ! ");

        return errors;

    }
}
