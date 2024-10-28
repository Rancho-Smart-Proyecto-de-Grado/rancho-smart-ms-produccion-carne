package com.rancho_smart.ms_produccion_carne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_produccion_carne.entity.ProduccionCarne;
import com.rancho_smart.ms_produccion_carne.repository.ProduccionCarneRepository;

@Service
public class ProduccionCarneService {

    @Autowired
    private ProduccionCarneRepository produccionCarneRepository;

    public List<ProduccionCarne> getProduccionesCarne() {
        return this.produccionCarneRepository.findAll();
    }

    public Optional<ProduccionCarne> getProduccionCarneById(Long id) {
        return this.produccionCarneRepository.findById(id);
    }

    public ProduccionCarne saveProduccionCarne(ProduccionCarne produccionCarne) {
        return this.produccionCarneRepository.save(produccionCarne);
    }

    public void deleteProduccionCarne(Long id) {
        this.produccionCarneRepository.deleteById(id);
    }
}
