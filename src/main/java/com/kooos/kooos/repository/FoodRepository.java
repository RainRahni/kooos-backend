package com.kooos.kooos.repository;

import com.kooos.kooos.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
