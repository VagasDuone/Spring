package com.example.RexComputantis;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
