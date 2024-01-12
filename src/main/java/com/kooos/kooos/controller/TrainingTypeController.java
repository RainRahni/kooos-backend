package com.kooos.kooos.controller;

import com.kooos.kooos.service.impl.TrainingTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trainingType")
@RequiredArgsConstructor
public class TrainingTypeController {
    private final TrainingTypeServiceImpl trainingTypeService;

    /**@PostMapping("/{trainingType}")
    public void saveNewTrainingType(@PathVariable String trainingType) {
        trainingTypeService.saveTrainingType(trainingType);
    }

    @GetMapping
    public List<String> getAllTypes() {
        return trainingTypeService.getTrainingTypes();
    }*/
}
