package com.kooos.kooos.service;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.model.scheduled.Schedulable;

public interface BaseService<T extends Schedulable> {
    T getNextItem(Long id, ScheduleDTO schedule);
}
