package com.rancho_smart.ms_produccion_carne.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_produccion_carne.Entity.Carne;
import com.rancho_smart.ms_produccion_carne.Service.CarneService;



@RestController
@RequestMapping("/carne")

public class CarneRestController {
 @Autowired
    private CarneService carneService;

    @PostMapping
    public ResponseEntity<Carne> registrarProduccion(@RequestBody Carne carne) {
        Carne nuevaCarne = carneService.createProduccion(carne);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCarne);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carne> getCarneById(@PathVariable Long id) {
        return ResponseEntity.ok(carneService.getProduccionCarneById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Carne>> getAllCarnes() {
        return ResponseEntity.ok(carneService.getAllProduccionCarne());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarneById(@PathVariable Long id) {
        carneService.deleteProduccionCarneById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carne> updateCarne(@PathVariable Long id, @RequestBody Carne carne) {
        return ResponseEntity.ok(carneService.updateProduccionCarne(id, carne));
    }
     // Obtener registros de carne por lote, ordenados por fecha de extracción de manera descendente
     @GetMapping("/lote/{idLote}")
     public List<Carne> getProduccionByLote(@PathVariable Long idLote) {
         return carneService.getProduccionByLote(idLote);
     }
 
     // Obtener registros de carne por animal, ordenados por fecha de extracción de manera descendente
     @GetMapping("/animal/{idAnimal}")
     public List<Carne> getProduccionByAnimal(@PathVariable Long idAnimal) {
         return carneService.getProduccionByAnimal(idAnimal);
     }
 
     // Obtener registros de carne por lote y rango de fechas
     @GetMapping("/lote/{idLote}/{meses}")
     public List<Carne> getProduccionByLoteAndFecha(@PathVariable Long idLote, @PathVariable int meses) {
         return carneService.getProduccionByLoteAndFecha(idLote, meses);
     }
 
     // Obtener registros de carne por animal y rango de fechas
     @GetMapping("/animal/{idAnimal}/{meses}")
     public List<Carne> getProduccionByAnimalAndFecha(@PathVariable Long idAnimal, @PathVariable int meses) {
         return carneService.getProduccionByAnimalAndFecha(idAnimal, meses);
     }
}
