package com.gainstar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @GetMapping("/api")
    public String getApi() {
        return "Hello from a bloated Java framework";
    }
}
