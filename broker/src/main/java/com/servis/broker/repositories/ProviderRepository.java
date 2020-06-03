package com.servis.broker.repositories;

import com.servis.broker.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

;import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider,Long> {

     Provider findByUsername(String username);
     Optional<Provider> findById(Long id);

}
