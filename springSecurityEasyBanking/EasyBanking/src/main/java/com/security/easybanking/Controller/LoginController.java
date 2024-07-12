package com.security.easybanking.Controller;

import com.security.easybanking.Model.Customer;
import com.security.easybanking.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try{
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully Registered");
            }
        }catch(Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception Occured due to "+e.getMessage());
        }
        return response;
    }
}
