package com.microworld.ems.eventservice.exception;

import lombok.Value;

@Value
public class ValidationException extends IllegalArgumentException {
    private String errorMessage;
}
