package com.rancho_smart.ms_produccion_carne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_produccion_carne.entity.ProduccionCarne;
import java.util.List;


@Repository
public interface ProduccionCarneRepository extends JpaRepository<ProduccionCarne, Long>{
    public List<ProduccionCarne> findByIdAnimal(Long idAnimal);
    public List<ProduccionCarne> findByIdFinca(Long idFinca);
    public List<ProduccionCarne> findByIdLote(Long idLote);
}
