package com.servis.broker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Endpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String naziv;
    @OneToOne
    Provider provider;
    @OneToOne
    Service1 service1;
    @OneToMany
    List<User> User = new ArrayList<>();
    @Column
    String parametar;
    //vise endpointa??
}
