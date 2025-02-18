package com.sell_buy.api.service;

import com.sell_buy.api.request.MemberRegisterReq;
import com.sell_buy.db.entity.Member;

public interface MemberService {
    Member getMemberByLoginId(String loginId);

    void registerMember(MemberRegisterReq dto);
}
