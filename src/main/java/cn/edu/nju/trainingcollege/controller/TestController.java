package cn.edu.nju.trainingcollege.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "test")
    public String index() {

        return "Hello World!!!";
    }
}
