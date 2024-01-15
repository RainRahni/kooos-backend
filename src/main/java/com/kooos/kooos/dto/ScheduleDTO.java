package com.kooos.kooos.dto;

import lombok.Builder;
@Builder
public record ScheduleDTO(String dayTime, String day) {
}
