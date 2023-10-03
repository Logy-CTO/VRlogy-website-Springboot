package com.example.demo.service;

import com.example.demo.domain.MemberInfo;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean login(String username, String password) {
        MemberInfo member = memberRepository.findByUsername(username);

        if (member != null && member.getPassword().equals(password)) {
            // 로그인 성공
            return true;
        }

        // 로그인 실패
        return false;
    }
}
