package com.security.easybanking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "Here are Account details from DB";
    }
}
