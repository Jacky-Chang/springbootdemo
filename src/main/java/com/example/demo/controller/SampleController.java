package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JackyChang on 17/9/4.
 *
 */
@RestController
public class SampleController {

    @RequestMapping("/")
    String home() {
        return "hello world!";
    }
}
