package com.servis.broker.model;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Catalog {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToMany
    private List<Service1> service1List = new ArrayList<>();


//test123
//bla

}
