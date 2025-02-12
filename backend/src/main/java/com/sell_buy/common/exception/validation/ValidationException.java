package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;

public class ValidationException extends RuntimeException {
    private final ValidationErrorCode errorCode;

    public ValidationException(String context, String message) {
        super(String.format("%s (Context: %s)", context, message));
        this.errorCode = ValidationErrorCode.;
    }
}
