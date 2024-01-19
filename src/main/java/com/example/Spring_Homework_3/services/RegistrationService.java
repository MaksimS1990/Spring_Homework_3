package com.example.Spring_Homework_3.services;

import com.example.Spring_Homework_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    // автоматическое добавление поля через IOC
    @Autowired
    UserService userService;
    // автоматическое добавление поля через IOC
    @Autowired
    DataProcessingService dataProcessingService;
    NotificationService notificationService;

    // добавление поля через конструктор
    public RegistrationService () {
        notificationService = new NotificationService();
    }

    public UserService getUserService() {
        return userService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    /**
     * Метод добавления юзера
     * @param user на вход принимаем юзера из обработчика
     * @return возвращаем текст о том, что юзер создан
     */
    public String processRegistration(User user) {
        dataProcessingService.addUserToList(user);
        return notificationService.notifyUser(user);
    }
    // public void processRegistration(User user){
    //     notificationService.notifyUser(user); // Перенёс из UserService
    //     dataProcessingService.addUserToList(user);
    // }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
