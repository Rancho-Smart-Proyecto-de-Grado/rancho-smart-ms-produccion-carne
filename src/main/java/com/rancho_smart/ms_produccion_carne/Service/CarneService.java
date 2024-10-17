package com.rancho_smart.ms_produccion_carne.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_produccion_carne.Entity.Carne;
import com.rancho_smart.ms_produccion_carne.Repository.CarneRepository;

@Service
public class CarneService {
    @Autowired
    private CarneRepository carneRepository;

    public Carne createProduccion(Carne carne) {
        return carneRepository.save(carne);
    }

    public Carne getProduccionCarneById(Long id) {
        return carneRepository.findById(id).orElseThrow(() -> new RuntimeException("Carne no encontrada"));
    }

    public List<Carne> getAllProduccionCarne() {
        return carneRepository.findAll();
    }

    public void deleteProduccionCarneById(Long id) {
        carneRepository.deleteById(id);
    }

    public Carne updateProduccionCarne(Long id, Carne updatedCarne) {
        return carneRepository.findById(id)
                .map(carne -> {
                    carne.setIdLote(updatedCarne.getIdLote());
                    carne.setIdAnimal(updatedCarne.getIdAnimal());
                    carne.setFechaExtraccion(updatedCarne.getFechaExtraccion());
                    carne.setPeso(updatedCarne.getPeso());
                    return carneRepository.save(carne);
                })
                .orElseThrow(() -> new RuntimeException("Carne no encontrada"));
    }

 // Obtener registros de carne por lote, ordenados por fecha de extracción de manera descendente
 public List<Carne> getProduccionByLote(Long idLote) {
    return carneRepository.findByIdLoteOrderByFechaExtraccionDesc(idLote);
}

// Obtener registros de carne por animal, ordenados por fecha de extracción de manera descendente
public List<Carne> getProduccionByAnimal(Long idAnimal) {
    return carneRepository.findByIdAnimalOrderByFechaExtraccionDesc(idAnimal);
}

// Obtener registros de carne por lote y rango de fechas, ordenados por fecha de extracción de manera descendente
public List<Carne> getProduccionByLoteAndFecha(Long idLote, int meses) {
    LocalDate fechaFin = LocalDate.now();
    LocalDate fechaInicio = fechaFin.minusMonths(meses);
    return carneRepository.findByIdLoteAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(idLote, fechaInicio, fechaFin);
}

// Obtener registros de carne por animal y rango de fechas, ordenados por fecha de extracción de manera descendente
public List<Carne> getProduccionByAnimalAndFecha(Long idAnimal, int meses) {
    LocalDate fechaFin = LocalDate.now();
    LocalDate fechaInicio = fechaFin.minusMonths(meses);
    return carneRepository.findByIdAnimalAndFechaExtraccionBetweenOrderByFechaExtraccionDesc(idAnimal, fechaInicio, fechaFin);
}

}
