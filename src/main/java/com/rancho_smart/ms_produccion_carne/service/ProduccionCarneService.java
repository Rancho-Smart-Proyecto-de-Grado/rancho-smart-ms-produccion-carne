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

    public List<ProduccionCarne> getProduccionesCarneByIdAnimal(Long idAnimal){
        return this.produccionCarneRepository.findByIdAnimal(idAnimal);
    }

    public List<ProduccionCarne> getProduccionesCarneByIdFinca(Long idFinca){
        return this.produccionCarneRepository.findByIdFinca(idFinca);
    }

    public List<ProduccionCarne> getProduccionesCarneByIdLote(Long idLote){
        return this.produccionCarneRepository.findByIdLote(idLote);
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
