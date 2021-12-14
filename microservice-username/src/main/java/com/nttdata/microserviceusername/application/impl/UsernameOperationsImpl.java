package com.nttdata.microserviceusername.application.impl;

import com.nttdata.microserviceusername.application.UsernameOperations;
import com.nttdata.microserviceusername.application.model.UsernameRepository;
import com.nttdata.microserviceusername.domain.Username;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsernameOperationsImpl implements UsernameOperations {

    @Autowired
    private final UsernameRepository repository;

    @Override
    public Flux<Username> queryAll() {
        return repository.getAll();
    }

    @Override
    public Mono<Username> findId(String id) {
        return repository.getId(id);
    }

    @Override
    public Mono<Username> create(Username username) {
        return repository.save(username);
    }

    @Override
    public Mono<Username> update(String id, Username username) {
        return repository.update(id, username);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.delete(id);
    }
}
