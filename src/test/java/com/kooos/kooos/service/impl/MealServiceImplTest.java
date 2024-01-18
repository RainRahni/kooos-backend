package com.kooos.kooos.service.impl;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.exception.BadRequestException;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.model.Schedule;
import com.kooos.kooos.model.User;
import com.kooos.kooos.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MealServiceImplTest {
    @Mock
    private MealRepository mealRepository;
    @InjectMocks
    private MealServiceImpl mealService;

    @Test
    void Given_UserIdAndSchedule_When_InformationCorrect_Then_ReturnNextMeal() {
        User user = User.builder().userName("Kevin Mc").id(1L).build();
        Schedule schedule = Schedule.builder().day("Monday").dayTime("11:30AM").build();
        ScheduleDTO schedule1 = ScheduleDTO.builder().day("Monday").dayTime("02:00PM").build();
        Schedule schedule2 = Schedule.builder().day("Monday").dayTime("08:00PM").build();

        Meal breakfast = Meal.builder().user(user).schedule(schedule).build();
        Meal dinner = Meal.builder().user(user).schedule(schedule2).build();

        given(mealRepository.findByUserIdAndScheduleDay(1L, "Monday"))
                .willReturn((List.of(breakfast, dinner)));

        var actual = mealService.getNextItem(1L, schedule1);

        then(mealRepository).should().findByUserIdAndScheduleDay(1L, schedule1.day());
        assertEquals(dinner, actual);
    }
    @Test
    void Given_UserIdAndSchedule_When_NoMealsInDatabase_Then_ThrowException() {
        Long userId = 1L;
        ScheduleDTO schedule1 = ScheduleDTO.builder().day("Monday").dayTime("02:00PM").build();

        given(mealRepository.findByUserIdAndScheduleDay(1L, "Monday"))
                .willThrow(BadRequestException.class);
        assertThrows(BadRequestException.class, () -> mealService.getNextItem(userId, schedule1));

        then(mealRepository).should().findByUserIdAndScheduleDay(userId, schedule1.day());
    }

}