package com.ruinfre.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Fakultet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nazivFakulteta;
    @OneToMany
    private List<Smer> smeroviNaFakultetu = new ArrayList<>();
    //@OneToMany(cascade = {CascadeType.MERGE})
    @OneToMany
    private List<Student> studentiNaFakultetu = new ArrayList<>();
}
