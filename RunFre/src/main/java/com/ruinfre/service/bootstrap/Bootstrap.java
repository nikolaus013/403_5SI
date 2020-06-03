package com.ruinfre.service.bootstrap;

import com.ruinfre.service.domain.*;
import com.ruinfre.service.repositories.*;
import com.ruinfre.service.services.MailService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final FakultetRepository fakultetRepository;
    private final RoleRepository roleRepository;

    private final UplataRepository uplataRepository;
    private final OcenaRepository ocenaRepository;
    private final SmerRepository smerRepository;
    private final IndexRepository indexRepository;

    @Autowired
    public Bootstrap(StudentRepository studentRepository, FakultetRepository fakultetRepository, RoleRepository roleRepository,  UplataRepository uplataRepository, OcenaRepository ocenaRepository, SmerRepository smerRepository, IndexRepository indexRepository) {
        this.studentRepository = studentRepository;
        this.fakultetRepository = fakultetRepository;
        this.roleRepository = roleRepository;

        this.uplataRepository = uplataRepository;
        this.ocenaRepository = ocenaRepository;
        this.smerRepository = smerRepository;
        this.indexRepository = indexRepository;
    }




    private void initData(){




        Student s1 = new Student();
        Fakultet f1 = new Fakultet();
        f1.setNazivFakulteta("RAF");
        fakultetRepository.save(f1);
        Ocena o1 = new Ocena();
        Ocena o2 = new Ocena();
        Ocena o3 = new Ocena();
        o1.setOcena(6);
        o2.setOcena(7);
        o3.setOcena(8);
        List<Ocena> ocene = new ArrayList<>();
        ocene.add(o1);
        ocene.add(o2);
        ocene.add(o3);
        ocenaRepository.save(o1);
        ocenaRepository.save(o2);
        ocenaRepository.save(o3);
        Uplata u1 = new Uplata();
        u1.setUplata(5000);
        Uplata u2 = new Uplata();
        u2.setUplata(4000);
        List<Uplata> uplate = new ArrayList<>();
        uplate.add(u1);
        uplate.add(u2);
        uplataRepository.save(u1);
        uplataRepository.save(u2);
        Smer smer1 = new Smer();
        smer1.setNazivSmera("RN");
        smerRepository.save(smer1);


        s1.setFirstName("Miki");
        s1.setLastName("Maus");
        s1.setIndex(30);
        s1.setOceneStudenta(ocene);
        s1.setUplateStudenta(uplate);
        s1.setFakultet(f1);
        s1.setSmerStudenta(smer1);

        s1.setUsername("Mix");


        studentRepository.save(s1);






    }


    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    /*private void initData(){

        Role r1 = new Role();
        r1.setName("ADMIN");
        Role r2 = new Role();
        r2.setName("STUDENT");
        roleRepository.save(r1);
        roleRepository.save(r2);

        Student s1 = new Student();
        Fakultet f1 = new Fakultet();
        f1.setNazivFakulteta("RAF");
        fakultetRepository.save(f1);
        Ocena o1 = new Ocena();
        Ocena o2 = new Ocena();
        Ocena o3 = new Ocena();
        o1.setOcena(6);
        o2.setOcena(7);
        o3.setOcena(8);
        List<Ocena> ocene = new ArrayList<>();
        ocene.add(o1);
        ocene.add(o2);
        ocene.add(o3);
        ocenaRepository.save(o1);
        ocenaRepository.save(o2);
        ocenaRepository.save(o3);
        Uplata u1 = new Uplata();
        u1.setUplata(5000);
        Uplata u2 = new Uplata();
        u2.setUplata(4000);
        List<Uplata> uplate = new ArrayList<>();
        uplate.add(u1);
        uplate.add(u2);
        uplataRepository.save(u1);
        uplataRepository.save(u2);
        Smer smer1 = new Smer();
        smer1.setNazivSmera("RN");
        smerRepository.save(smer1);


        s1.setFirstName("Miki");
        s1.setLastName("Maus");
        s1.setIndex(30);
        s1.setOceneStudenta(ocene);
        s1.setUplateStudenta(uplate);
        s1.setFakultet(f1);
        s1.setSmerStudenta(smer1);
        s1.getRoles().add(roleRepository.findByName("ADMIN"));
        s1.setUsername("Mix");
        s1.setPassword(bCryptPasswordEncoder.encode("123"));

        studentRepository.save(s1);

    }*/
}
