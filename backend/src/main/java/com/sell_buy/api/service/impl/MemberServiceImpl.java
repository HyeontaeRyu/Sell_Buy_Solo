package com.sell_buy.api.service.impl;

import com.sell_buy.api.request.MemberRegisterPostReq;
import com.sell_buy.api.service.MemberService;
import com.sell_buy.db.entity.Member;
import com.sell_buy.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member getMemberByLoginId(String loginId) {
        return null;
    }

    @Override
    public Long registerMember(MemberRegisterPostReq dto) {
        
    }
}
