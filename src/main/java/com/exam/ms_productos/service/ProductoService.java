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
    private ProductoRepository repo;
    public Producto save(Producto p) { return repo.save(p); }
    public List<Producto> findAll() { return repo.findAll(); }
    public Optional<Producto> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}