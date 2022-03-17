package com.example.TransactionDemo.controller;

import com.example.TransactionDemo.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController("accountController")
@RequestMapping("/account")
public class Controller {
    @Autowired
    AccountService accountService;

    @GetMapping("{outMan}/{inMan}/{money}")
    public void getById(@PathVariable String outMan, @PathVariable String inMan, @PathVariable int money) {
        accountService.transfer(outMan, inMan, money);
    }
}
