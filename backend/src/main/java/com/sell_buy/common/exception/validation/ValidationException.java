package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final ValidationErrorCode errorCode;

    public ValidationException(ValidationErrorCode errorCode, String context, String message) {
        super(String.format("%s (Context: %s)", message, context));
        this.errorCode = errorCode;
    }
}