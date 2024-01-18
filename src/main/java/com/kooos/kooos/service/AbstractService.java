package com.kooos.kooos.service;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.exception.BadRequestException;
import com.kooos.kooos.model.scheduled.Schedulable;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public abstract class AbstractService<T extends Schedulable> {
    public T getNextItem(Long id, ScheduleDTO schedule) {
        //TODO add so that this is only accessible for registered users.
        List<T> itemsInDay = getItemsByUserIdAndScheduleDay(id, schedule.day());
        T nextItem = findMinDifference(findDifferences(itemsInDay, schedule.dayTime()));
        if (nextItem != null) {
            return nextItem;
        }
        throw new BadRequestException(String.format("No %ss created!", nextItem.getClass().getSimpleName()));
    }
    private T findMinDifference(HashMap<T, Integer> objectsWithDifferences) {
        Map.Entry<T, Integer> minEntry = null;
        for (Map.Entry<T, Integer> entry : objectsWithDifferences.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry.getKey();
    }
    private HashMap<T, Integer> findDifferences(List<T> suitableObjects, String time) {
        HashMap<T, Integer> objectsDiffWithNeededTime = new HashMap<>();
        for (T object: suitableObjects) {
            String timeString = object.getSchedule().getDayTime();
            int millis = getMillis(timeString);
            int neededMillis = getMillis(time);
            int difference = millis - neededMillis;
            if (difference > 0) {
                objectsDiffWithNeededTime.put(object, difference);
            }
        }
        return objectsDiffWithNeededTime;
    }
    private int getMillis(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        LocalTime time = LocalTime.parse(timeString, formatter);
        return time.toSecondOfDay() * 1000;
    }
    protected abstract List<T> getItemsByUserIdAndScheduleDay(Long id, String day);
}
