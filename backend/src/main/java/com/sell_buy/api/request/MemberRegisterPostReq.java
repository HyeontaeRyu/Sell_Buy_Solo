package com.sell_buy.api.request;

import lombok.Data;

@Data
public class MemberRegisterPostReq {
    String loginId;
    String password;
    String name;
    String nickname;
    String email;
    Integer phone;
}
