package com.example.sbmp.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
	@Value("${info.profile:World!}")
    String bar;
    @GetMapping("/test")
    public String test() {
        return "PROVIDER" + bar;
    }
}
