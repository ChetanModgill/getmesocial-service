package com.example.getmesocialservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreatedValidator implements ConstraintValidator<ValidCreatedBy, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.matches("[a-z1-9 ]+")){
            return true;
        }
        else{
            return false;
        }
    }
}
