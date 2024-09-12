package com.scaler.firstspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @GetMapping("sayBye")
    public String sayBye(){
        return "Bye Everyone";
    }
}
