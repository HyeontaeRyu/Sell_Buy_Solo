package com.sell_buy.exception.validation;

import com.sell_buy.exception.errorCode.ValidationErrorCode;

public class StringRegexValidateException extends StringValidationException {
    public StringRegexValidateException(String context, String regex, String errStr) {
        super(context, String.format("Not matching string with regex '%s'", regex), errStr, ValidationErrorCode.VALIDATION_INVALID);
    }
}