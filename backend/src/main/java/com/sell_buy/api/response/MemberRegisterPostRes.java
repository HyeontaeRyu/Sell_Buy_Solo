package com.sell_buy.api.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberRegisterPostRes {
    private Long id;
    private String loginId;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime regDate;
}
