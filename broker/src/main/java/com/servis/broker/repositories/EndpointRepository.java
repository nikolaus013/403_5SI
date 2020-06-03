package com.servis.broker.repositories;

import com.servis.broker.model.Endpoint;
import com.servis.broker.model.Service1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointRepository extends JpaRepository<Endpoint,Long> {

    Endpoint findByNaziv(String naziv);

}
