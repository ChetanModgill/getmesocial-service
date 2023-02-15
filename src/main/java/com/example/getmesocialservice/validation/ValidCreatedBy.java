package com.example.getmesocialservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreatedValidator.class)
@Documented
public @interface ValidCreatedBy {
    String message() default "Not valid, letters should be lower case or numbers";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
