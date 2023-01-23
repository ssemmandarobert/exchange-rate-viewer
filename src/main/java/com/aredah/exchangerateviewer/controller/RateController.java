package com.aredah.exchangerateviewer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RateController {

    @GetMapping(path = "/test")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.accepted().body("hello world Stack");
    }
}
