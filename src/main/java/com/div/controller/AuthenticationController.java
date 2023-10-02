package com.div.controller;

import com.div.model.dto.DriverDto;
import com.div.model.dto.SignUpDto;
import com.div.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("app/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpDto signUpDto) {
        log.info("Post - /signup -> request ", signUpDto);
        var response = service.signup(signUpDto);
        log.info("Post - /signup -> response -> ", response);
        if (response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/confirmation/{uuid}")
    public ResponseEntity<?> confirmation (@PathVariable UUID uuid){
        log.info("Get - /signup -> request ", uuid);
        var response = service.enableUpdate(uuid);
        log.info("Post - /signup -> response -> ", response);
        if (response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
