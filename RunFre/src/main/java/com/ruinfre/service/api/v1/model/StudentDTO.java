package com.ruinfre.service.api.v1.model;

import com.ruinfre.service.domain.*;
import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private String id;
    private String fName;
    private String lName;
    private Integer indx;
    private String username;
    private String password;
    private Fakultet fakul;
    private Smer smerStd;
    private List<Predmet> listaPredmeta;
    private List<Ocena> listaOcena;
    private List <Uplata> listaUplata;
}
