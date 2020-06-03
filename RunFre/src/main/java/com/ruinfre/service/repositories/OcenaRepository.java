package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Ocena;
import com.ruinfre.service.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {
    Ocena findByOcena(Integer ocena);
}
