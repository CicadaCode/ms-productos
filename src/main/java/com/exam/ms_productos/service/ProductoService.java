package com.exam.ms_productos.service;

import com.exam.ms_productos.entity.Producto;
import com.exam.ms_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto save(Producto p) { return productoRepository.save(p); }
    public List<Producto> findAll() { return productoRepository.findAll(); }
    public Optional<Producto> findById(Long id) { return productoRepository.findById(id); }
    public void delete(Long id) { productoRepository.deleteById(id); }
}