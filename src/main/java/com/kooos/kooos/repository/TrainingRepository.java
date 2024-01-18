package com.kooos.kooos.repository;

import com.kooos.kooos.model.Meal;
import com.kooos.kooos.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends BaseRepository<Training, Long> {
}
