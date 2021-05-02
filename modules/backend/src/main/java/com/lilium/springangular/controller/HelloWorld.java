package com.lilium.springangular.controller;

import com.lilium.springangular.dto.HelloWorldDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public HelloWorldDTO getHelloWorldMessage() {
        System.out.println("oi");
        HelloWorldDTO dto = new HelloWorldDTO();
        dto.setMessage("Hello World Spring with Angular");
        return dto;
    }

}
