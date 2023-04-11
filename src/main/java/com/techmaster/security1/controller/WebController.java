package com.techmaster.security1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web-controller")
public class WebController {
    @GetMapping("dash-board")
    public ResponseEntity<?> getDashBoard(){
        return ResponseEntity.ok("Dash board");
    }
    @GetMapping("user")
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok("User");
    }
    @GetMapping("category")
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok("Category");
    }
    @GetMapping("product")
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.ok("Product");
    }
    @GetMapping("brand")
    public ResponseEntity<?> getBrand(){
        return ResponseEntity.ok("Brand");
    }
    @GetMapping("order")
    public ResponseEntity<?> getOrder(){
        return ResponseEntity.ok("Order");
    }
    @GetMapping("post")
    public ResponseEntity<?> getPost(){
        return ResponseEntity.ok("Post");
    }
    @GetMapping("user-info")
    public ResponseEntity<?> getUserDetail(){
        return ResponseEntity.ok("User Info");
    }
}
