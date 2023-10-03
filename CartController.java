package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam int memberId, @RequestParam String productName) {
        Cart cart = new Cart();
        cart.setMemberId(memberId);
        cart.setProductName(productName);
        cartRepository.save(cart);
        return "cart";
    }
}