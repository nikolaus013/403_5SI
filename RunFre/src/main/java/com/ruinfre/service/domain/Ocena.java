package com.ruinfre.service.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer ocena;
}
