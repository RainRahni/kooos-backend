package com.kooos.kooos.service;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.model.Schedule;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Meal getNextMeal(Long id, ScheduleDTO schedule);
}
