package com.sell_buy.api.service.impl;

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
    public Long registerMember(Member member) throws Exception {
        if (member.getLoginId().isEmpty() || member.getPassword().isEmpty() || member.getNickname().isEmpty()) {
            throw new Exception("Invalid input");

        }
        System.out.println(member.getLoginId());
        Validator<StringValidation> validator = new Validator<>(new IdValidation(member.getLoginId()),
                new PasswordValidation(member.getPassword()));
        if (!validator.isValid()) {
            throw new Exception("Invalid input");
        }
        if (memberRepository.findByLoginId(member.getLoginId()).isPresent()) {
            throw new Exception("Login ID already exists");
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member registeredMember = memberRepository.save(member);
        Point point = Point.builder().memId(registeredMember.getMemId()).balance(0).build();
        pointRepository.save(point);

        return registeredMember.getMemId();
    }
}
