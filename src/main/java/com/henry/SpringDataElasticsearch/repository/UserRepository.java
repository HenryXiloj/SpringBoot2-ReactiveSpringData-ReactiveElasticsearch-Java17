package com.henry.SpringDataElasticsearch.repository;

import com.henry.SpringDataElasticsearch.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Flux<User> findByName(String name);
}
