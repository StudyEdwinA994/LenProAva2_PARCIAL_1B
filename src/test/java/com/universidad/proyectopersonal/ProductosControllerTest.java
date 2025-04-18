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
import java.util.Arrays;
import java.util.List;

public class ProductosControllerTest {

    @Mock
    private ProductosRepository repository;

    @InjectMocks
    private ProductosController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductos() {
        ProductosModel producto1 = new ProductosModel(1L, "Computador escritorio", 2000000.0f, "12 meses", 10);
        ProductosModel producto2 = new ProductosModel(2L, "Computador portatil", 2500000.0f, "12 meses", 15);
        List<ProductosModel> productos = Arrays.asList(producto1, producto2);

        when(repository.findAll()).thenReturn(productos);

        List<ProductosModel> resultado = controller.getProductos();

        assertEquals(2, resultado.size());
    }
}
