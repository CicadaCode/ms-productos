package com.exam.ms_productos.service;

import com.exam.ms_productos.entity.Producto;
import com.exam.ms_productos.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    void setUp() {
        // Initialize a sample Producto with all attributes
        producto = Producto.builder()
                .id(1L)
                .nombre("Producto 1")
                .precio(100.0)
                .categoria("Electronics")
                .build();  // Using Lombok's builder for ease of testing
    }

    @Test
    void testSave() {
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto savedProducto = productoService.save(producto);

        verify(productoRepository, times(1)).save(producto);

        assertEquals(producto, savedProducto);
    }

    @Test
    void testFindAll() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));

        List<Producto> productos = productoService.findAll();

        verify(productoRepository, times(1)).findAll();

        assertNotNull(productos);
        assertFalse(productos.isEmpty());
        assertEquals(1, productos.size());
        assertEquals("Producto 1", productos.get(0).getNombre());
    }

    @Test
    void testFindById() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> foundProducto = productoService.findById(1L);

        verify(productoRepository, times(1)).findById(1L);

        assertTrue(foundProducto.isPresent());
        assertEquals(producto, foundProducto.get());
    }

    @Test
    void testDelete() {
        doNothing().when(productoRepository).deleteById(1L);

        productoService.delete(1L);

        verify(productoRepository, times(1)).deleteById(1L);
    }
}