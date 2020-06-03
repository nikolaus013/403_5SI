package com.ruinfre.service.domain;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Data
@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @ManyToMany
    private List<Smer> smerovi = new ArrayList<>();


}
