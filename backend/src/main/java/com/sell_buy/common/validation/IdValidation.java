package com.sell_buy.common.validation;

public class IdValidation extends StringValidation {
    public IdValidation(String value) {
        super("Validating Id", value, "^[a-z0-9_]+$", 8, 20, false);
    }
}
