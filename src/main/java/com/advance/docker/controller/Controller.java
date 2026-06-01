package com.advance.docker.controller;

import com.advance.docker.dto.AccountDetails;
import com.advance.docker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Controller {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String hello() {
        System.out.println("this is hello controller");
        return "Hello from Dockerized Spring Boot!";
    }

    @GetMapping(value = "/getAccount")
    public ResponseEntity<AccountDetails> getAccountDetails(@RequestParam String accountNo){
        AccountDetails accountDetails= accountService.fetchAccountDetails(accountNo);
        return ResponseEntity.status(HttpStatus.OK).body(accountDetails);
    }
}
