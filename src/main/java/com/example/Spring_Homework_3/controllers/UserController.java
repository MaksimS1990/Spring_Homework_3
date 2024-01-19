package com.example.Spring_Homework_3.controllers;

import com.example.Spring_Homework_3.domain.User;
import com.example.Spring_Homework_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") // localhost:8080/user
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        return registrationService.processRegistration(user);
    }

    @RequestMapping("/body/{name}-{age}-{email}")                                   // регистрация в карте обработчиков
    public String userAddFromHTML(@ModelAttribute("user") User user){
        return registrationService.processRegistration(user);
    }
}
