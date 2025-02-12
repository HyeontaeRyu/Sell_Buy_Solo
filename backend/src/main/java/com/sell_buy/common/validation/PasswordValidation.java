package com.sell_buy.common.validation;

public class PasswordValidation extends StringValidation {
    public PasswordValidation(String value) {
        super("Validating password", value,
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&.]+$",
                10, 30, false);
    }
}
