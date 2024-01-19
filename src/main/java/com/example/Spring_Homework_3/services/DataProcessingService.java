package com.example.Spring_Homework_3.services;

import com.example.Spring_Homework_3.domain.User;
import com.example.Spring_Homework_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    UserRepository userRepository;

    public List<User> sortUserByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing((User::getAge))).collect(Collectors.toList());
    }

    public List<User> filterUserByAge(List<User> users, int age) {
        return users.stream().filter(u -> u.getAge() > age).collect(Collectors.toList());
    }

    public double calculateAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

//    public void addUserToList(User user) {
//        userRepository.getUsers().add(user);
//    }

    public void addUserToList(User user) {
        userRepository.add(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}