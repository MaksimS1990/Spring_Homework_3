package com.example.Spring_Homework_3.services;

import com.example.Spring_Homework_3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

        public String notifyUser(User user) {
            String message = "A new user has been created: " + user.getName();
            System.out.println(message);
            return message;
        }
}
