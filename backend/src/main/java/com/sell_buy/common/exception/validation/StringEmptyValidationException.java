package com.sell_buy.common.exception.validation;

import com.sell_buy.common.exception.errorCode.ValidationErrorCode;

public class StringEmptyValidationException extends StringValidationException {
    public StringEmptyValidationException(ValidationErrorCode errorCode, String context, String errStr) {
        super(errorCode, context, "This string is null or empty", errStr);
    }
}
