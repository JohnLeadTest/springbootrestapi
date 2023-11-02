package com.techlover.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// suffix with Controller
//@Controller
//@ResponseBody

@RestController // is a combination of Controller & ResponseBody
public class HelloWorldController {
//    this is where we specify rest api end points

    // http GET request - http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

}
