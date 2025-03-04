package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<String> getDemoEndpoint() {
        return ResponseEntity.ok("GET: This endpoint is accessible by both USER and ADMIN");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> postDemoEndpoint() {
        return ResponseEntity.ok("POST: This endpoint is accessible only by ADMIN");
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> putDemoEndpoint() {
        return ResponseEntity.ok("PUT: This endpoint is accessible only by ADMIN");
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteDemoEndpoint() {
        return ResponseEntity.ok("DELETE: This endpoint is accessible only by ADMIN");
    }
}