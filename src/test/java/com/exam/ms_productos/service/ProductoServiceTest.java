package com.exam.ms_productos.service;

import com.exam.ms_productos.entity.Producto;
import com.exam.ms_productos.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductoServiceTest {
    @Mock
    private ProductoRepository repo;
    @InjectMocks
    private ProductoService svc;

    @Test
    void SaveAndReturnProducto() {
        Producto p = Producto.builder().nombre("X").precio(10.0).categoria("A").build();
        when(repo.save(any())).thenReturn(p);
        Producto result = svc.save(p);
        assertEquals("X", result.getNombre());
        verify(repo).save(p);
    }
}