package com.example.Spring_Homework_3.services;

import com.example.Spring_Homework_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        notificationService.notifyUser(user);
        dataProcessingService.addUserToList(user);
    }

    // public void processRegistration(User user){
    //     notificationService.notifyUser(user); // Перенёс из UserService
    //     dataProcessingService.addUserToList(user);
    // }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
