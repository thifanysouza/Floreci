package com.api.florecicontrol.repositories;

import com.api.florecicontrol.models.FloreciModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FloreciRepository extends JpaRepository<FloreciModel, UUID> {

    boolean existsByNomeDaPlanta(String nomeDaPlanta);
}
