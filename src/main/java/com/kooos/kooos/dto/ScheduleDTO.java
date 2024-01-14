package com.kooos.kooos.dto;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public record ScheduleDTO(String dayTime, String day) {
}
