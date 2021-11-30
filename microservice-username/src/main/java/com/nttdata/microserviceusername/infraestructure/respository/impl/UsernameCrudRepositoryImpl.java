package com.nttdata.microserviceusername.infraestructure.respository.impl;

import com.nttdata.microserviceusername.application.model.UsernameRepository;
import com.nttdata.microserviceusername.domain.Username;
import com.nttdata.microserviceusername.infraestructure.model.dao.UsernameDao;
import com.nttdata.microserviceusername.infraestructure.respository.IUsernameCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UsernameCrudRepositoryImpl implements UsernameRepository {

    @Autowired
    private IUsernameCrudRepository repository;

    @Override
    public Mono<Username> getId(String id) {
        return repository.findById(id)
                .map(this::mapUsernameDaoToUser);
    }

    @Override
    public Flux<Username> getAll() {
        return repository.findAll()
                .map(this::mapUsernameDaoToUser);
    }

    @Override
    public Mono<Username> save(Username username) {
        return repository.save(mapUsernameToUserDao(username))
                .map(this::mapUsernameDaoToUser);
    }

    @Override
    public Mono<Username> update(String id, Username username) {
        return repository.save(mapUsernameToUserDao(username))
                .map(this::mapUsernameDaoToUser);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }





    //metodos

    private Username mapUsernameDaoToUser(UsernameDao usernameDao){
        Username username = new Username();
        username.setId(usernameDao.getId());
        username.setDni(usernameDao.getDni());
        username.setName(usernameDao.getName());
        username.setLastname(usernameDao.getLastname());
        username.setDatebirth(usernameDao.getDatebirth());
        return username;
    }

    private UsernameDao mapUsernameToUserDao(Username username){
        UsernameDao usernameDao = new UsernameDao();
        usernameDao.setId(username.getId());
        usernameDao.setDni(username.getDni());
        usernameDao.setName(username.getName());
        usernameDao.setLastname(username.getLastname());
        usernameDao.setDatebirth(username.getDatebirth());
        return usernameDao;
    }



}
