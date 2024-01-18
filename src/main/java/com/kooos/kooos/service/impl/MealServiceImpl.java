package com.kooos.kooos.service.impl;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.repository.MealRepository;
import com.kooos.kooos.service.AbstractService;
import com.kooos.kooos.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl extends AbstractService<Meal> implements MealService {
    private final MealRepository mealRepository;
    @Override
    public Meal getNextItem(Long id, ScheduleDTO schedule) {
        return super.getNextItem(id, schedule);
    }
    @Override
    public List<Meal> getItemsByUserIdAndScheduleDay(Long id, String day) {
        return mealRepository.findByUserIdAndScheduleDay(id, day);
    }
}
