package com.div.controller;

import com.div.model.dto.DriverDto;
import com.div.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/app/v1/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService service;
    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("Get - /user->request none");
        var response = service.findAll();
        log.info("Get - /user - response -> {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        log.info("Get - /user/{} -> request ", id);
        var response = service.findById(id);
        log.info("Get - /user/{} - response -> {}", id, response);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody DriverDto driverDto) {
        log.info("Post - /user -> request ", driverDto);
        var response = service.save(driverDto);
        log.info("Post - /user -> response -> ", response);
        if (response==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody DriverDto driverDto) {
        log.info("Put - /user -> request ", driverDto);
        var response = service.updateById(id,driverDto);
        log.info("Put - /user -> response ", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        log.info("Delete - /user -> request ", id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
