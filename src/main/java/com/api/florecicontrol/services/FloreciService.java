package com.api.florecicontrol.services;

import com.api.florecicontrol.models.FloreciModel;
import com.api.florecicontrol.repositories.FloreciRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FloreciService {
    final FloreciRepository floreciRepository;

    public FloreciService(FloreciRepository floreciRepository) {
        this.floreciRepository = floreciRepository;
    }


    public boolean existsByNomeDaPlanta(String nomeDaPlanta) {
        return floreciRepository.existsByNomeDaPlanta(nomeDaPlanta);

    }

    @Transactional
    public FloreciModel save(FloreciModel floreciModel) {
        return floreciRepository.save(floreciModel);

    }

    public Page<FloreciModel> findAll(Pageable pageable) {
        return floreciRepository.findAll(pageable);
    }

    public Optional<FloreciModel> findById(UUID id) {
        return floreciRepository.findById(id);
    }

    @Transactional
    public void delete(FloreciModel floreciModel) {
        floreciRepository.delete(floreciModel);
    }
}

