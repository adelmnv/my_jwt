package kz.itstep.jwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/path")
public class TestController {
    @GetMapping
    public String get(){
        return "you are authenticated";
    }
}
