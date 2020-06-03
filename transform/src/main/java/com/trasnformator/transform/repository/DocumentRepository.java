package com.trasnformator.transform.repository;

import com.trasnformator.transform.model.Dokument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends MongoRepository<Dokument,Long> {
    Optional <Dokument> findById(Long id);
}
