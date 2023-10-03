package com.example.demo.session;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @GetMapping("/check-authentication")
    public ResponseEntity<?> checkAuthentication(HttpSession session){
        boolean authenticated = false;
        if(session.getAttribute("username")!=null){
            authenticated=true;
        }

        Map<String,Object> response=new HashMap<>();
        response.put("authenticated",authenticated);
        return ResponseEntity.ok().body(response);
    }
}