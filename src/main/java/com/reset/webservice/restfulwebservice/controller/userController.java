package com.reset.webservice.restfulwebservice.controller;

import com.reset.webservice.restfulwebservice.Entity.User;
import com.reset.webservice.restfulwebservice.Exception.UserNotFoundException;
import com.reset.webservice.restfulwebservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }


    //HATEOAS
    @GetMapping(path = "/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user = userService.findUserById(id);

        if(user == null)
            throw new UserNotFoundException("id-" + id);

        // The link to all users, SERVER_PATH+"/users" using the method to add the link
        EntityModel<User> resource = EntityModel.of(user);
        //build the link to the retrieveAllUser
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        //add to the result resource
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    /*
    * Create user so the user must be validated. Otherwise we return a response about the invalidation.
    */
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
