package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Fakultet;
import com.ruinfre.service.domain.Smer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FakultetRepository extends JpaRepository<Fakultet,Long> {
    Fakultet findByNazivFakulteta(String nazivFakulteta);
    Fakultet findBySmeroviNaFakultetu(Smer smeroviNaFakultetu);

}
