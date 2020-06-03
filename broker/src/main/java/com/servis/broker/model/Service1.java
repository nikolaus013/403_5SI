package com.servis.broker.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Service1 {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nazivServisa;

    @Column
    String hostServisa;
    
    @OneToOne(cascade = {CascadeType.ALL})
    Provider provider;

    @OneToMany(cascade = {CascadeType.ALL})
    List<Endpoint> endpointi=new ArrayList<>();

}
