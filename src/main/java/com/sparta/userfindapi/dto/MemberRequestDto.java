package com.sparta.userfindapi.dto;

import com.sparta.userfindapi.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private String email;
    private String pw;

    public MemberRequestDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }
}
