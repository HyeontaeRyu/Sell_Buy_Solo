package com.sell_buy.api.request;

import com.sell_buy.components.validation.ValidatableMember;

public record MemberUpdateReq(String email, String phone, String nickname) implements ValidatableMember {
}
