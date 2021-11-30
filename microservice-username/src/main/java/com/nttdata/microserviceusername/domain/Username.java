package com.nttdata.microserviceusername.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Username {

    @Id
    private String id;
    private String dni;
    private String name;
    private String lastname;
    private String datebirth;

}
