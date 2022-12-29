package com.sparta.userfindapi.service;

import com.sparta.userfindapi.dto.MemberRequestDto;
import com.sparta.userfindapi.dto.MemberResponseDto;
import com.sparta.userfindapi.dto.ResponseMessageDto;
import com.sparta.userfindapi.entity.Member;
import com.sparta.userfindapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto memberDto) {
        Member member = new Member(memberDto);
        memberRepository.save(member);
        return new MemberResponseDto(member);
    }

    @Transactional
    public List<MemberRequestDto> findAllMember() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberRequestDto::new).collect(Collectors.toList());
    }

    @Transactional
    public MemberRequestDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                ()->new NullPointerException("회원 상세 조회 실패")
        );
        return new MemberRequestDto(member);
    }

    @Transactional
    public ResponseMessageDto updateMember(Long id, MemberRequestDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("id가 존재하지 않습니다.")
        );
        if(!memberDto.getPw().equals(member.getPw())){
            return new ResponseMessageDto("비밀번호가 일치하지 않습니다.");
        }
        member.update(memberDto);
        return new ResponseMessageDto("수정 성공!");
    }

    @Transactional
    public ResponseMessageDto deleteMember(Long id, MemberRequestDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("id가 존재하지 않습니다.")
        );
        if(!memberDto.getPw().equals(member.getPw())) {
            return new ResponseMessageDto("비밀번호가 일치하지 않습니다.");
        }
        memberRepository.deleteById(id);
        return new ResponseMessageDto("삭제 성공!");
    }
}
