package com.ruinfre.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer index;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Ocena> oceneStudenta = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE})
   private List<Uplata> uplateStudenta = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.MERGE})
    private Fakultet fakultet;

    @OneToOne(cascade = {CascadeType.MERGE})
    private Smer smerStudenta;

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<Predmet> predmetiStudenta = new ArrayList<>();

    @Column
    private String username;

    @Column
    private String password;





}
