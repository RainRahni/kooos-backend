package com.kooos.kooos.service.impl;

import com.kooos.kooos.dto.ScheduleDTO;
import com.kooos.kooos.model.Training;
import com.kooos.kooos.repository.TrainingRepository;
import com.kooos.kooos.service.AbstractService;
import com.kooos.kooos.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl extends AbstractService<Training> implements TrainingService {
    private final TrainingRepository trainingRepository;
    @Override
    public Training getNextItem(Long id, ScheduleDTO schedule) {
        return super.getNextItem(id, schedule);
    }
    @Override
    public List<Training> getItemsByUserIdAndScheduleDay(Long id, String day) {
        return trainingRepository.findByUserIdAndScheduleDay(id, day);
    }
}
