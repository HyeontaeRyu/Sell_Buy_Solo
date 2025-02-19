package com.sell_buy.exception.validation;

import com.sell_buy.exception.errorCode.ValidationErrorCode;
import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
    private final ValidationErrorCode errorCode;

    public ValidationException(String context, String message, ValidationErrorCode errorCode) {
        super(String.format("%s (Context: %s, Code: %s)", message, context, errorCode.name()));
        this.errorCode = errorCode;
    }

    public ValidationErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorCode.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
