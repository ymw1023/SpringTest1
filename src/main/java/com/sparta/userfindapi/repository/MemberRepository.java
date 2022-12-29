package com.sparta.userfindapi.repository;

import com.sparta.userfindapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
