package com.servis.broker.bootstrap;

import com.servis.broker.model.Catalog;
import com.servis.broker.model.Provider;
import com.servis.broker.model.Service1;
import com.servis.broker.model.ServiceRequest;
import com.servis.broker.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CatalogRepository catalogRepository;
    private final ProviderRepository providerRepository;
    private final ServiceRpository serviceRpository;
    private final UserRepository userRepository;


    @Autowired
    public Bootstrap(CatalogRepository catalogRepository, ProviderRepository providerRepository,  ServiceRpository serviceRpository, UserRepository userRepository) {
        this.catalogRepository = catalogRepository;
        this.providerRepository = providerRepository;
        this.serviceRpository = serviceRpository;
        this.userRepository = userRepository;
    }





    private void initData() {
        //Katalog
        Catalog c1 = new Catalog();
        //Servis
        Service1 s1 = new Service1();
        s1.setNazivServisa("Studenti");
        s1.setHostServisa("google.com");


        //Provajder
        Provider p1 = new Provider();
        p1.setHost("google.com");
        p1.setUsername("test");
        p1.setPassword("123");

        //Service Request
        ServiceRequest sq1 = new ServiceRequest();

        sq1.setZahtev("broker.com/google/test");

        List<Service1> listaServisa = new ArrayList<>();
        listaServisa.add(s1);

        p1.setListaServisa(listaServisa);
        s1.setProvider(p1);
        c1.setService1List(listaServisa);

        providerRepository.save(p1);
        serviceRpository.save(s1);

        catalogRepository.save(c1);








    }
    @Override
    public void run(String... args) throws Exception {
        initData();
    }

}
