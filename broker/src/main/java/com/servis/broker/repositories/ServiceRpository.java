package com.servis.broker.repositories;

import com.servis.broker.model.Service1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRpository extends JpaRepository<Service1,Long> {

    Optional<Service1> findById(Long id);
    Service1 findByNazivServisa(String naziv);
    Service1 findByHostServisa(String host);
}
