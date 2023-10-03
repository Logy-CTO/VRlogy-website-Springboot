package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html 또는 login.jsp와 같은 템플릿 파일의 이름
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        boolean loggedIn = loginService.login(username, password);

        if (loggedIn) {
            model.addAttribute("message", "로그인 성공");
            return "redirect:/index";
        } else {
            model.addAttribute("message", "로그인 실패");
            return "login";
        }
    }
}
