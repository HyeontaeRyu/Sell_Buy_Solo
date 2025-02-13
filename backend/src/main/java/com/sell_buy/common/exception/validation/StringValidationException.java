package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;

public class StringValidationException extends ValidationException {

    public StringValidationException(ValidationErrorCode errorCode, String context, String message, String errStr) {
        super(errorCode, context, String.format("%s - Error String: %s", message, errStr));
    }
}