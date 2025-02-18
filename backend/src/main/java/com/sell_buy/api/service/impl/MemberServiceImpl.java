package com.sell_buy.api.service.impl;

import com.sell_buy.api.request.MemberRegisterReq;
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
    public void registerMember(MemberRegisterReq dto) {
        Member member = Member.builder()
                .loginId(dto.loginId())
                .password(passwordEncoder.encode(dto.password()))
                .name(dto.name())
                .nickname(dto.nickname())
                .email(dto.email())
                .phone(dto.phone())
                .build();
        memberRepository.save(member);
    }
}
