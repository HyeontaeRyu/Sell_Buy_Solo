package com.sell_buy.common.exception.validation;

public class StringEmptyValidationException extends StringValidationException {
    public StringEmptyValidationException(String context, String errStr) {
        super(context, "This string is null or empty", errStr);
    }
}
