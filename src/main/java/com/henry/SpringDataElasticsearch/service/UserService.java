package com.henry.SpringDataElasticsearch.service;

import com.henry.SpringDataElasticsearch.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> save(User user);

    Mono<User> update(Long id, User user);

    Mono<Void> delete(Long id);

    Mono<User> findOne(Long id);

    Flux<User> findAll();

    Flux<User> findByName(String name);
}
