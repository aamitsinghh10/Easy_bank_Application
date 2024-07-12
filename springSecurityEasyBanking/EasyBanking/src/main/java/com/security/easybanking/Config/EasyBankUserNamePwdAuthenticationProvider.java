package com.security.easybanking.Config;

import com.security.easybanking.Model.Customer;
import com.security.easybanking.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class EasyBankUserNamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<Customer> customer = customerRepository.findByEmail(username);

        if(customer.size()>0){
            if(passwordEncoder.matches(pwd,customer.get(0).getPwd())){
                List<GrantedAuthority> authorities = new ArrayList<>();

                return new UsernamePasswordAuthenticationToken(username,pwd,authorities);
            } else{
                throw new BadCredentialsException("Invalid Password!");
            }
        }else{
            throw new BadCredentialsException("No details registered with this details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
