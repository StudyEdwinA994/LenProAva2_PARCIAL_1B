package com.universidad.proyectopersonal;

import com.universidad.proyectopersonal.controller.ProductosController;
import com.universidad.proyectopersonal.model.ProductosModel;
import com.universidad.proyectopersonal.repository.ProductosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CrearProductosControllerTest {

    @Mock
    private ProductosRepository repository;

    @InjectMocks
    private ProductosController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearProducto() {
        ProductosModel nuevoProducto = new ProductosModel(1L, "Tablet", 600000f, "12 meses", 8);

        when(repository.save(nuevoProducto)).thenReturn(nuevoProducto);

        String resultado = controller.crearProducto(nuevoProducto);

        assertEquals("¡Producto creado!", resultado);

        verify(repository, times(1)).save(nuevoProducto);
    }
}
