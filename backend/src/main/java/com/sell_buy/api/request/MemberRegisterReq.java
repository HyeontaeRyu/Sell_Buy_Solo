package com.sell_buy.api.request;

import com.sell_buy.components.validation.ValidatableMember;

public record MemberRegisterReq(String loginId,
                                String password,
                                String name,
                                String nickname,
                                String email,
                                String phone) implements ValidatableMember {
}
