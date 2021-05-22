package com.reset.webservice.restfulwebservice.controller;

import com.reset.webservice.restfulwebservice.Entity.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    /*
    * Return a simple string
    */
    @GetMapping(path = "/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    /*
    * Return a bin
    */
    @GetMapping(path = "/helloWorld-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    /*
    * Request with a path parameter
    */
    @GetMapping(path = "/helloWorld/path-variable/{name}")
    public HelloWorldBean getBean(@PathVariable String name){
        return new HelloWorldBean(name);
    }
}
