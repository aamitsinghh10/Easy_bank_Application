package com.security.easybanking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getLoanDetails(){
        return "Here are details about Loans that I had Taken from DB";
    }
}
