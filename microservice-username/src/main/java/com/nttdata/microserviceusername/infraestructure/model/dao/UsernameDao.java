package com.nttdata.microserviceusername.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("username")
public class UsernameDao {

    @Id
    private String id;
    private String dni;
    private String name;
    private String lastname;
    private String datebirth;
}
