package com.kooos.kooos.controller;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;
    @GetMapping("/nextMeal/{id}/{")
    public Meal getNextMeal(@PathVariable("id") Long id, @RequestBody ScheduleDTO scheduleDTO) {
        return userServiceImpl.getNextMeal(id, scheduleDTO);
    }
}
