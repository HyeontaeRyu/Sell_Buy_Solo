package com.sell_buy.common.validation;

import com.sell_buy.common.exception.validation.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class Validator<T extends Validation> {
    private final List<T> validations;

    public Validator() {
        validations = new ArrayList<>();
    }

    public Validator(T... validations) {
        this.validations = new ArrayList<>(List.of(validations));
    }

    public boolean isValid() throws ValidationException {
        for (T validation : validations) {
            if (!validation.validate()) {
                return false;
            }
        }
        return true;

    }
}
