package com.kooos.kooos.service;

import com.kooos.kooos.model.Meal;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Meal getNextMeal(Long id);
}
