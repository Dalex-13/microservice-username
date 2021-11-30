package com.nttdata.microserviceusername.application;

import com.nttdata.microserviceusername.domain.Username;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsernameOperations {

    public Flux<Username> queryAll();
    public Mono<Username> findId(String id);
    public Mono<Username> create(Username username);
    public Mono<Username> update(String id, Username username);
    public Mono<Void> delete(String id);
}
