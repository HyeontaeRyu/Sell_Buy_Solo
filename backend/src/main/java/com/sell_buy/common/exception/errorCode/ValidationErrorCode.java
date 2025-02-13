package com.sell_buy.common.exception.errorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ValidationErrorCode {
    VALIDATION_COMMON(HttpStatus.UNPROCESSABLE_ENTITY, "VALIDATION_ERROR_COMMON", "유효성 검사에 실패하였습니다."),
    VALIDATION_DUPLICATE(HttpStatus.UNPROCESSABLE_ENTITY, "VALIDATION_ERROR_DUPLICATE", "중복된 데이터가 존재합니다."),
    VALIDATION_INVALID(HttpStatus.UNPROCESSABLE_ENTITY, "VALIDATION_ERROR_INVALID", "잘못된 입력값 입니다."),
    VALIDATION_EMPTY(HttpStatus.UNPROCESSABLE_ENTITY, "VALIDATION_ERROR_EMPTY", "필수 값이 누락되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
