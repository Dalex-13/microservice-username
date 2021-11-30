package com.nttdata.microserviceusername.infraestructure.respository;

import com.nttdata.microserviceusername.infraestructure.model.dao.UsernameDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IUsernameCrudRepository extends ReactiveCrudRepository<UsernameDao, String> {
}
