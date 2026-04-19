package org.vsitcnt.vcount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vsitcnt.vcount.dto.TestDTO;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public TestDTO sayHello() {
        return new TestDTO("Hello there!");
    }
}
