package com.reset.webservice.restfulwebservice.controller;

import com.reset.webservice.restfulwebservice.Entity.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    /*
    * Return a simple string
    */
    @GetMapping(path = "/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/helloWorld-i18n")
    public String helloWorldi18n(){
        // en = Hello World
        // nl = Goede Morgen
        // fr = Bonjour
        // use the file to store the
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());

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
