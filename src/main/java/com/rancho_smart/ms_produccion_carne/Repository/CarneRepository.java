package com.rancho_smart.ms_produccion_carne.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_produccion_carne.Entity.Carne;



@Repository
public interface CarneRepository extends JpaRepository<Carne, Long> {
    
    List<Carne> findByIdLoteOrderByFechaExtraccionDesc(Long idLote);

    List<Carne> findByIdAnimalOrderByFechaExtraccionDesc(Long idAnimal);

    List<Carne> findAllByOrderByFechaExtraccionDesc();

    List<Carne> findByIdLoteAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(Long idLote, LocalDate startDate, LocalDate endDate);

    List<Carne> findByIdAnimalAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(Long idAnimal, LocalDate startDate, LocalDate endDate);
}
