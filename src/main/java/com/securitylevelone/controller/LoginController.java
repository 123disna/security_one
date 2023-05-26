package com.securitylevelone.controller;

import com.securitylevelone.model.User;
import com.securitylevelone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody User user){
        ResponseEntity response=null;
        try {
            String hashPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPwd);
            User savedUser=userRepo.save(user);
            if(savedUser.getId()>0){
                response=ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Successfully registered");
            }
        }catch (Exception e){
             response=ResponseEntity
                     .status(HttpStatus.CREATED)
                     .body("Exception occurs due to "+e.getMessage());
        }
        return response;
    }
}
