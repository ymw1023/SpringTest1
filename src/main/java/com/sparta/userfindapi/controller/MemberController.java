package com.sparta.userfindapi.controller;

import com.sparta.userfindapi.dto.MemberRequestDto;
import com.sparta.userfindapi.dto.MemberResponseDto;
import com.sparta.userfindapi.dto.ResponseMessageDto;
import com.sparta.userfindapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public MemberResponseDto postMember(@RequestBody MemberRequestDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @GetMapping("/member")
    public List<MemberRequestDto> getMemberList() {
        return memberService.findAllMember();
    }

    @GetMapping("member/{id}")
    public MemberRequestDto getMemberInfo(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    @PutMapping("member/{id}")
    public ResponseMessageDto updateMember(@PathVariable Long id, @RequestBody MemberRequestDto memberDto) {
        return memberService.updateMember(id, memberDto);
    }

    @DeleteMapping("member/{id}")
    public ResponseMessageDto deleteMember(@PathVariable Long id, @RequestBody MemberRequestDto memberDto) {
        return memberService.deleteMember(id, memberDto);
    }
}
