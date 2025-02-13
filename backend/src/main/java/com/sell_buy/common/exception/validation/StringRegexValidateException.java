package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;

public class StringRegexValidateException extends StringValidationException {
    public StringRegexValidateException(ValidationErrorCode errorCode, String context, String regex, String errStr) {
        super(errorCode, context, String.format("Not matching string with regex '%s'", regex), errStr);
    }
}