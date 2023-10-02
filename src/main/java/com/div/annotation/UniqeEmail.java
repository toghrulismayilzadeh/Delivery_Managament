package com.div.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqeEmailValidator.class)
@Documented
public @interface UniqeEmail {
    String message() default "{company.registration.annotation.UniqeEmail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}