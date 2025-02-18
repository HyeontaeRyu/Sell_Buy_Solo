package com.sell_buy.api.controller;

import com.sell_buy.api.request.MemberRegisterReq;
import com.sell_buy.api.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> registerMember(@RequestBody @Valid MemberRegisterReq dto) {
        memberService.registerMember(dto);
        return ResponseEntity.ok().build();
    }
}
