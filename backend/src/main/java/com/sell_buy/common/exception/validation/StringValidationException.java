package com.sell_buy.common.exception.validation;

public class StringValidationException extends ValidationException {
    public StringValidationException(String context, String message, String errStr) {
        super(context, String.format("%s - Error String: %s", message, errStr));
    }
}