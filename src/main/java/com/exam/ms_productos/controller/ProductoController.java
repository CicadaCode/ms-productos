package com.exam.ms_productos.controller;

import com.exam.ms_productos.entity.Producto;
import com.exam.ms_productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .categoria(dto.getCategoria())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(p));
    }

    @GetMapping
    public List<Producto> list() {
        return productoService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto dto) {
        return productoService.findById(id).map(orig -> {
            orig.setNombre(dto.getNombre());
            orig.setPrecio(dto.getPrecio());
            orig.setCategoria(dto.getCategoria());
            return ResponseEntity.ok(productoService.save(orig));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}