package com.security.easybanking.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String savedContactEnquiryDetails(){
        return "Enquiry details are saved on the DB";
    }
}
