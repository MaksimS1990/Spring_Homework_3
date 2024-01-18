package com.example.Spring_Homework_3.services;

import com.example.Spring_Homework_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public String processRegistration(UserService userService, DataProcessingService dataProcessingService) {
        return null;
    }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
