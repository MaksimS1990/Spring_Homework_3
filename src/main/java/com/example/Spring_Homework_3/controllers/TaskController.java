package com.example.Spring_Homework_3.controllers;

import com.example.Spring_Homework_3.domain.User;
import com.example.Spring_Homework_3.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") // localhost:8080/tasks
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return dataProcessingService.sortUserByAge(dataProcessingService.getUserRepository().getUsers());
    }

    /**
     * Метод возвращает отфильтрованный список юзеров по возрасту (старше заданного значения)
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUserByAge(dataProcessingService.getUserRepository().getUsers(), age);
    }

    /**
     * Метод возвращает среднее арифметическое возратов юзеров
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAge(dataProcessingService.getUserRepository().getUsers());
    }

    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")

    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")
}