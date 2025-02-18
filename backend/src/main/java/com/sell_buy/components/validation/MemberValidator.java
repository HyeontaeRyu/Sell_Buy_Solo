package com.sell_buy.components.validation;

import com.sell_buy.api.request.MemberRegisterReq;
import com.sell_buy.api.request.MemberUpdateReq;
import com.sell_buy.db.repository.MemberRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class MemberValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&.]{10,30}+$");
    private static final Pattern LOGIN_ID_PATTERN = Pattern.compile("^[a-z0-9_]{8,20}+$");
    private static final Pattern NICKNAME_PATTERN = Pattern.compile("^[가-힣a-zA-Z0-9]{2,10}$");
    private static final Pattern PHONE_NUM_PATTERN = Pattern.compile("^[0-9]{10,15}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[가-힣a-zA-Z\\s]{2,10}$");
    private final MemberRepository memberRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return ValidatableMember.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        if (target instanceof MemberRegisterReq) {
            validateRegister((MemberRegisterReq) target, errors);
        } else if (target instanceof MemberUpdateReq) {
            validateUpdate((MemberUpdateReq) target, errors);
        }
    }

    private void validateRegister(MemberRegisterReq dto, Errors errors) {
        validateName(dto.name(), errors);
        validateEmail(dto.email(), errors);
        validatePassword(dto.password(), errors);
        validateLoginId(dto.loginId(), errors);
        validateNickname(dto.nickname(), errors);
        validatePhoneNum(dto.phone(), errors);
    }

    private void validateUpdate(MemberUpdateReq dto, Errors errors) {
        validateEmail(dto.email(), errors);
        validateNickname(dto.nickname(), errors);
        validatePhoneNum(dto.phone(), errors);
    }

    private void validateName(String name, Errors errors) {
        if (!NAME_PATTERN.matcher(name).matches()) {
            errors.rejectValue("name", "Invalid.name", "Name must be between 2 and 10 characters long and can include Korean characters");
        }
    }

    private void validateEmail(String email, Errors errors) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            errors.rejectValue("email", "Invalid.email", "Invalid email format or email is null");
        }
        if (memberRepository.existsByEmail(email)) {
            errors.rejectValue("email", "Duplicate.email", "Email already exists");
        }
    }

    private void validatePassword(String password, Errors errors) {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            errors.rejectValue("password", "Invalid.password", "Password must be at least 10 characters long and include uppercase, lowercase, number, and special character");
        }
    }

    private void validateLoginId(String loginId, Errors errors) {
        if (!LOGIN_ID_PATTERN.matcher(loginId).matches()) {
            errors.rejectValue("loginId", "Invalid.loginId", "Login ID must be up to 20 characters long");
        }
        if (memberRepository.existsByLoginId(loginId)) {
            errors.rejectValue("loginId", "Duplicate.loginId", "Login ID already exists");
        }
    }

    private void validateNickname(String nickname, Errors errors) {
        if (!NICKNAME_PATTERN.matcher(nickname).matches()) {
            errors.rejectValue("nickname", "Invalid.nickname", "Nickname must be between 2 and 10 characters long and can include Korean characters");
        }
        if (memberRepository.existsByNickname(nickname)) {
            errors.rejectValue("nickname", "Duplicate.nickname", "Nickname already exists");
        }
    }

    private void validatePhoneNum(String phoneNum, Errors errors) {
        if (!PHONE_NUM_PATTERN.matcher(phoneNum).matches()) {
            errors.rejectValue("phoneNum", "Invalid.phoneNum", "Phone number must be between 10 and 15 characters long");
        }
        if (memberRepository.existsByPhone(phoneNum)) {
            errors.rejectValue("phoneNum", "Duplicate.phoneNum", "Phone number already exists");
        }
    }


}
