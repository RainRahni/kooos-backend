package com.kooos.kooos.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Nutrition {
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
}
