package com.kooos.kooos.service.impl;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.exception.BadRequestException;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.repository.MealRepository;
import com.kooos.kooos.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    @Override
    public Meal getNextMeal(Long id, ScheduleDTO schedule) {
        //TODO add so that this is only accessible for registered users.
        List<Meal> mealsInDay = mealRepository.findByUserIdAndScheduleDay(id, schedule.day());
        Meal nextMeal = findMinDifferenceMeal(findDifferences(mealsInDay, schedule.dayTime()));
        if (nextMeal != null) {
            return nextMeal;
        }
        throw new BadRequestException("No meals created!");
    }
    private Meal findMinDifferenceMeal(HashMap<Meal, Integer> mealsWithDifferences) {
        Map.Entry<Meal, Integer> minEntry = null;
        for (Map.Entry<Meal, Integer> entry : mealsWithDifferences.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry.getKey();
    }

    private HashMap<Meal, Integer> findDifferences(List<Meal> suitableMeals, String time) {
        HashMap<Meal, Integer> mealsDiffNeededTime = new HashMap<>();
        for (Meal meal: suitableMeals) {
            String timeString = meal.getSchedule().getDayTime();
            int millis = getMillis(timeString);
            int neededMillis = getMillis(time);
            int difference = millis - neededMillis;
            if (difference > 0) {
                mealsDiffNeededTime.put(meal, difference);
            }
        }
        return mealsDiffNeededTime;
    }
    private int getMillis(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time.toSecondOfDay() * 1000;
    }
}
