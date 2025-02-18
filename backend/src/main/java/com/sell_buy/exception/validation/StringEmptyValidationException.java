package com.sell_buy.exception.validation;

import com.sell_buy.exception.errorCode.ValidationErrorCode;

public class StringEmptyValidationException extends StringValidationException {
    public StringEmptyValidationException(String context, String errStr) {
        super(context, "This string is null or empty", errStr, ValidationErrorCode.VALIDATION_EMPTY);
    }
}
