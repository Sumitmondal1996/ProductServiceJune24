package com.scaler.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This makes sure that the class will be hosting HTTP API's

@RequestMapping("/say") // Sets an address for the class

public class SampleController {

    @GetMapping("/hello/{name}/{times}") // Sets an address for method where data is read
    public String sayHello(@PathVariable("name") String s, @PathVariable("times") int t)
    {
        String str = "";
        for(int i = 0; i < t; i++)
        {
            str = str + " Hey " + s;
        }
        return str;

    }

    @GetMapping("/bye") // Sets an address for method where data is read
    public String saybye()
    {
        return "bye";

    }


}
