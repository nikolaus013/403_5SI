package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredmetRepository extends JpaRepository<Predmet,Long> {
    Predmet findByNaziv(String nazivPredmeta);
}
