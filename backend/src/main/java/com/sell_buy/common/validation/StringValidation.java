package com.sell_buy.common.validation;

import com.sell_buy.common.exception.validation.StringEmptyValidationException;
import com.sell_buy.common.exception.validation.StringLengthValidateException;
import com.sell_buy.common.exception.validation.StringRegexValidateException;
import com.sell_buy.common.exception.validation.StringValidationException;

public class StringValidation implements Validation {
    private final String value;
    private final String regex;
    private final String context;

    private final int min;
    private final int max;

    private final boolean exclusive;

    public StringValidation(String context, String value, String regex, int min, int max, boolean exclusive) {
        this.context = context;
        this.value = value;
        this.regex = regex;
        this.min = min;
        this.max = max;
        this.exclusive = exclusive;
    }

    public StringValidation(String context, String value, String regex, int min, int max) {
        this(context, value, regex, min, max, false);
    }

    public StringValidation(String context, String value) {
        this(context, value, null, 0, 0, false);
    }

    public StringValidation(String context, String value, String regex) {
        this(context, value, regex, 0, 0, false);
    }

    public StringValidation(String context, String value, int min, int max, boolean exclusive) {
        this(context, value, null, min, max, exclusive);
    }

    @Override
    public boolean validate() {
        return regexValidation() && lengthValidation() && emptyValidation();
    }

    private boolean regexValidation() throws StringValidationException {
        if (this.regex == null || this.regex.isEmpty()) {
            return true;
        } else {
            if (this.value.matches(regex)) {
                return true;
            }
        }
        throw new StringRegexValidateException(context, this.regex, this.value);
    }

    private boolean lengthValidation() throws StringValidationException {
        if (this.min == 0 && this.max == 0) {
            return true;
        } else {
            if (this.exclusive) {
                if (this.value.length() > this.min && this.value.length() < this.max) {
                    return true;
                }
            } else {
                if (this.value.length() >= this.min && this.value.length() <= this.max) {
                    return true;
                }
            }
        }
        throw new StringLengthValidateException(context, this.min, this.max, this.value);
    }

    private boolean emptyValidation() throws StringValidationException {
        if (this.value == null || this.value.isEmpty()) {
            throw new StringEmptyValidationException(context, this.value);
        }
        return true;
    }
}
