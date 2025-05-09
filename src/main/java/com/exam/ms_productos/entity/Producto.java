package com.exam.ms_productos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private Double precio;
    private String categoria;

    @Builder
    public Producto(Long id, String nombre, Double precio, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
}