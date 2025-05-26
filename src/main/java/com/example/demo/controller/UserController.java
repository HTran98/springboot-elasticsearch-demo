package com.example.demo.controller;

import com.example.demo.entity.UserDocument;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserService userService;

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDocument>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(userService.search(keyword));
    }
}