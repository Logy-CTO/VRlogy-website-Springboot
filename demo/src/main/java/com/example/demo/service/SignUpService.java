package com.example.demo.service;

import com.example.demo.domain.MemberInfo;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private final MemberRepository memberRepository;

    public SignUpService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(MemberInfo member) {
        // no password encoding
        memberRepository.save(member);
    }
}
