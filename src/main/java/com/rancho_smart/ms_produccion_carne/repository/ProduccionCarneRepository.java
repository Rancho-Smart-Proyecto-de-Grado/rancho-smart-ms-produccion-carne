package com.rancho_smart.ms_produccion_carne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_produccion_carne.entity.ProduccionCarne;

@Repository
public interface ProduccionCarneRepository extends JpaRepository<ProduccionCarne, Long>{
    
}
