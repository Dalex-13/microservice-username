package com.nttdata.microserviceusername.infraestructure.rest;


import com.nttdata.microserviceusername.application.UsernameOperations;
import com.nttdata.microserviceusername.domain.Username;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsernameController {

    @Autowired
    private CircuitBreakerFactory cbFactory;






    private final UsernameOperations usernameOperations;

    @GetMapping
    public Flux<Username> get() {
        log.info("Listado de usuarios");
        return usernameOperations.queryAll();
    }

    @GetMapping("/{id}")
    public Mono<Username> getId(@PathVariable String id) {
        return cbFactory.create("items")
                .run(()-> usernameOperations.findId(id));
    }

    @PostMapping("/add")
    public Mono<Username> post(@RequestBody Username username) {
        log.info("creacion de usuarios");
        return usernameOperations.create(username);
    }

    @PutMapping("/{id}")
    public Mono<Username> put(@PathVariable String id, @RequestBody Username username) {
        return usernameOperations.update(id, username);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){

        return usernameOperations.delete(id);
    }


}
