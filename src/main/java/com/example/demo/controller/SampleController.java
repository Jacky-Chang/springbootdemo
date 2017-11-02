package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JackyChang on 17/9/4.
 *
 */
@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "hello world!";
    }
}
