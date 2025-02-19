package com.sell_buy.exception.validation;

import com.sell_buy.exception.errorCode.ValidationErrorCode;

public class StringLengthValidateException extends StringValidationException {
    public StringLengthValidateException(String context, int min, int max, String errStr) {
        super(context, String.format("String length should be between %d and %d", min, max), errStr, ValidationErrorCode.VALIDATION_INVALID);
    }
}
