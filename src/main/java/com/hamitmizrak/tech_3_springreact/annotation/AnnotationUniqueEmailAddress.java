package com.hamitmizrak.tech_3_springreact.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Email Address unique
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueEmailAddressValidation.class})
public @interface AnnotationUniqueEmailAddress {

    String message() default "{register.email.validation.constraints.unique.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} //end class