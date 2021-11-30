package com.nttdata.microserviceusername.application.model;

import com.nttdata.microserviceusername.domain.Username;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsernameRepository {

    Mono<Username> getId(String id);
    Flux<Username> getAll();
    Mono<Username> save(Username username);
    Mono<Username> update(String id, Username username);
    Mono<Void> delete(String id);
}
