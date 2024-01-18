package com.kooos.kooos.repository;

import com.kooos.kooos.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, Long extends Serializable> extends JpaRepository<T, Long> {
    List<T> findByUserIdAndScheduleDay(Long id, String day);
}
