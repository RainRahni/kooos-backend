package com.kooos.kooos.service.impl;

import com.kooos.kooos.exception.BadRequestException;
import com.kooos.kooos.model.Meal;
import com.kooos.kooos.model.User;
import com.kooos.kooos.repository.UserRepository;
import com.kooos.kooos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Meal getNextMeal(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("No user with this id"));
        return null;
    }
}
