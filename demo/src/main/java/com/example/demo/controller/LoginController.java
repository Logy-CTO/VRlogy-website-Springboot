package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login 또는 login.jsp와 같은 템플릿 파일의 이름
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        boolean loggedIn = loginService.login(username, password);

        if (loggedIn) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("username", username);
            model.addAttribute("message", "로그인 성공");
            return "redirect:/";
        } else {
            model.addAttribute("message", "로그인 실패");
            // 로그인 실패 시 다른 페이지로 리다이렉션하거나, 아래와 같이 동일한 로그인 페이지를 반환하지 않도록 변경
            return "redirect:/login"; // 예: 에러 페이지로 이동
        }
    }
}
