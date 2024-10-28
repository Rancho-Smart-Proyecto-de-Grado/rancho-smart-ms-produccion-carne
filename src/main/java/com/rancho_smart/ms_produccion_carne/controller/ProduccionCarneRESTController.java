package com.rancho_smart.ms_produccion_carne.controller;

import java.util.List;
import java.util.Optional;

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

import com.rancho_smart.ms_produccion_carne.entity.ProduccionCarne;
import com.rancho_smart.ms_produccion_carne.service.ProduccionCarneService;

@RestController
@RequestMapping(path = "/producciones-carne")
public class ProduccionCarneRESTController {

    @Autowired
    private ProduccionCarneService produccionCarneService;

    @GetMapping
    public ResponseEntity<List<ProduccionCarne>> getAllProduccionesCarne() {
        List<ProduccionCarne> listado = this.produccionCarneService.getProduccionesCarne();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduccionCarne> getProduccionCarneById(@PathVariable Long id) {
        Optional<ProduccionCarne> produccionCarne = this.produccionCarneService.getProduccionCarneById(id);
        return produccionCarne.map(ResponseEntity::ok)
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProduccionCarne> saveProduccionCarne(@RequestBody ProduccionCarne produccionCarne) {
        ProduccionCarne produccionCarneCreada = this.produccionCarneService.saveProduccionCarne(produccionCarne);
        return new ResponseEntity<>(produccionCarneCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduccionCarne> updateProduccionCarne(@PathVariable Long id, @RequestBody ProduccionCarne produccionCarne) {
        if (!this.produccionCarneService.getProduccionCarneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produccionCarne.setIdProduccionCarne(id);
            ProduccionCarne produccionCarneActualizada = this.produccionCarneService.saveProduccionCarne(produccionCarne);
            return new ResponseEntity<>(produccionCarneActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduccionCarne(@PathVariable Long id) {
        if (!this.produccionCarneService.getProduccionCarneById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.produccionCarneService.deleteProduccionCarne(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
