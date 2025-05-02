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
    private ProductoService svc;

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .categoria(dto.getCategoria())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(svc.save(p));
    }

    @GetMapping
    public List<Producto> list() {
        return svc.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto dto) {
        return svc.findById(id).map(orig -> {
            orig.setNombre(dto.getNombre());
            orig.setPrecio(dto.getPrecio());
            orig.setCategoria(dto.getCategoria());
            return ResponseEntity.ok(svc.save(orig));
        }).orElse(ResponseEntity.notFound().build());
    }
}
