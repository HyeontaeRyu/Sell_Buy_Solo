package com.sell_buy.exception.validation;

import com.sell_buy.exception.errorCode.ValidationErrorCode;

public class StringValidationException extends ValidationException {
    public StringValidationException(String context, String message, String errStr, ValidationErrorCode errorCode) {
        super(context, String.format("%s - Error String: %s", message, errStr), errorCode);
    }
}