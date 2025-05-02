package com.exam.ms_productos.entity;

import jakarta.persistence.*;
import lombok.*;

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