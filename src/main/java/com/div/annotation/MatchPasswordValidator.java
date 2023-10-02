package com.div.annotation;

import com.div.model.dto.SignUpDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, SignUpDto> {
    @Override
    public boolean isValid(SignUpDto value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || Objects.equals(value.getPassword(),value.getConfrimPassword());
    }
}