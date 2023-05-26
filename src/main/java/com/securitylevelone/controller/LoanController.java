package com.securitylevelone.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/loan")
@RestController
@CrossOrigin
public class LoanController {

    @GetMapping("/my-loan")
    public String getLoan(){

        return "my loan";
    }
}
