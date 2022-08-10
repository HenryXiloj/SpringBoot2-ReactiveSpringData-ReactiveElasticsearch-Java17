package com.henry.SpringDataElasticsearch.service.impl;

import com.henry.SpringDataElasticsearch.model.User;
import com.henry.SpringDataElasticsearch.repository.UserRepository;
import com.henry.SpringDataElasticsearch.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> update(Long id, User user) {
        return userRepository.findById(id)
                .flatMap(u -> {
                    u.setName(user.getName());
                    u.setLastName(user.getLastName());
                    return userRepository.save(u);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        var del = userRepository.deleteById(id);
        return del;
    }

    @Override
    public Mono<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
