package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Smer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmerRepository extends JpaRepository<Smer,Long> {
    Smer findByNazivSmera(String nazivSmera);

}
