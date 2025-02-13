package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;

public class StringLengthValidateException extends StringValidationException {
    public StringLengthValidateException(ValidationErrorCode errorCode, String context, int min, int max, String errStr) {
        super(errorCode, context, String.format("String length should be between %d and %d", min, max), errStr);
    }
}
