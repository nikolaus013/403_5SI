package com.ruinfre.service.api.v1.model;


import com.ruinfre.service.domain.Student;
import com.ruinfre.service.domain.Smer;

import java.util.List;

public class FakultetDTO {

    private String id;
    private String naziv;
    private List<Smer> smerovi;
    private List<Student> studenti;
}
