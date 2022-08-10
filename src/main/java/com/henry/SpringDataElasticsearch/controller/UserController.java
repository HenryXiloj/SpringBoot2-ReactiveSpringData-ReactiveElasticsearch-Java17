package com.henry.SpringDataElasticsearch.controller;

import com.henry.SpringDataElasticsearch.model.User;
import com.henry.SpringDataElasticsearch.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public Mono<User> add(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update/{id}")
    public Mono<User> update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping("/findOne/{id}")
    public Mono<User> findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @GetMapping("/all")
    public Flux<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public Flux<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}


