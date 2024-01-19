package com.example.Spring_Homework_3.services;


import com.example.Spring_Homework_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        notificationService.notifyUser(user); // сообщение о создании пользователя
        return user;
    }
}