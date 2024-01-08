package com.kooos.kooos.dto;

import lombok.Builder;

@Builder
public record RegisterDTO(String userName, String email, String password) {
}
