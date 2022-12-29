package com.sparta.userfindapi.entity;

import com.sparta.userfindapi.dto.MemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pw;

    public Member(MemberRequestDto member) {
        this.update(member);
    }

    public void update(MemberRequestDto member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }
}
