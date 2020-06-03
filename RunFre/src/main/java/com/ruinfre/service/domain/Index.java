package com.ruinfre.service.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer index;
}
