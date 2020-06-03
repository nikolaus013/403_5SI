package com.ruinfre.service.repositories;

import com.ruinfre.service.domain.Index;
import com.ruinfre.service.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexRepository extends JpaRepository<Index, Long> {
    Index findByIndex(Integer index);
}
