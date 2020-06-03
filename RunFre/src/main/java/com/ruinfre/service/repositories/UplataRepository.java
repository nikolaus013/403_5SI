package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Student;
import com.ruinfre.service.domain.Uplata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UplataRepository extends JpaRepository<Uplata, Long> {
    Uplata findByUplata(Integer uplata);
}
