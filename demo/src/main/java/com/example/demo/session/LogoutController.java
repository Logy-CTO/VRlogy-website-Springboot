package com.example.demo.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 제거 (로그아웃)
        session.removeAttribute("username");

        return "redirect:/";
    }
}
