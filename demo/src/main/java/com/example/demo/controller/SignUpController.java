package com.example.demo.controller;

import com.example.demo.domain.MemberInfo;
import com.example.demo.service.SignUpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup"; // signup과 매칭될 것입니다.
    }

    @PostMapping("/signup")
    public String handleSignUp(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            // 비밀번호와 비밀번호 확인이 일치하지 않는 경우 에러 페이지로 리다이렉트하거나 에러 메시지 표시
            return "redirect:/signup";
        }

        MemberInfo member = new MemberInfo();
        member.setUsername(username);
        member.setPassword(password);

        signUpService.signUp(member);

        return "redirect:/"; // 인덱스 페이지로 리다이렉트
    }
}

