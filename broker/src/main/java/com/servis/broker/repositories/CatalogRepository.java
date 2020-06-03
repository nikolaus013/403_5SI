package com.servis.broker.repositories;

import com.servis.broker.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {

    Optional<Catalog> findById(Long id);
//test
}
