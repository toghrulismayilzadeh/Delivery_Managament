package com.div.annotation;

import com.div.model.dto.SignUpDto;
import com.div.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqeEmailValidator implements ConstraintValidator<UniqeEmail, SignUpDto> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(SignUpDto registrationDto, ConstraintValidatorContext constraintValidatorContext) {
        return registrationDto==null || !userRepository.existsByEmail(registrationDto.getEmail());
    }
}