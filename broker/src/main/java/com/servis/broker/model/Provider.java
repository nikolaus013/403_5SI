package com.servis.broker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String username;
    @Column
    String password;
    @Column
    String host;
    @OneToMany(cascade = {CascadeType.ALL})
    List<Service1> listaServisa = new ArrayList<>();
}
