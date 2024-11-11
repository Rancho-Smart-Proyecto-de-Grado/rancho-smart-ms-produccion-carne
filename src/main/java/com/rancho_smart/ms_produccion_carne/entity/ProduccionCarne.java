package com.rancho_smart.ms_produccion_carne.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCCION_CARNE")
public class ProduccionCarne {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduccionCarne;

    @Column(name = "ID_ANIMAL")
    private Long idAnimal;

    @Column(name = "PESO_REGISTRADO")
    private Float pesoRegistrado;

    @Column(name = "FECHA")
    private LocalDateTime fecha;    

    @Column(name = "ID_LOTE")
    private Long idLote;
    
    @Column(name = "ID_FINCA")
    private Long idFinca;

    public ProduccionCarne() {
    }

    public ProduccionCarne(Long idAnimal, Float pesoRegistrado, LocalDateTime fecha, Long idLote, Long idFinca) {
        this.idAnimal = idAnimal;
        this.pesoRegistrado = pesoRegistrado;
        this.fecha = fecha;
        this.idLote = idLote;
        this.idFinca = idFinca;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    public Long getIdProduccionCarne() {
        return idProduccionCarne;
    }

    public void setIdProduccionCarne(Long idProduccionCarne) {
        this.idProduccionCarne = idProduccionCarne;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Float getPesoRegistrado() {
        return pesoRegistrado;
    }

    public void setPesoRegistrado(Float pesoRegistrado) {
        this.pesoRegistrado = pesoRegistrado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    
}
