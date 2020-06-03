package com.ruinfre.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Smer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nazivSmera;
    @ManyToMany
    private List<Predmet> predmeti = new ArrayList<>();
}
