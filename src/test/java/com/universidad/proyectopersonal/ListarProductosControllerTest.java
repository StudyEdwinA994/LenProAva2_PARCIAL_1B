package com.universidad.proyectopersonal;

import com.universidad.proyectopersonal.controller.ProductosController;
import com.universidad.proyectopersonal.model.ProductosModel;
import com.universidad.proyectopersonal.repository.ProductosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListarProductosControllerTest {

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
        // Arrange
        ProductosModel producto1 = new ProductosModel(1L, "Teclado", 80000f, "6 meses", 20);
        ProductosModel producto2 = new ProductosModel(2L, "Mouse", 40000f, "6 meses", 15);
        List<ProductosModel> listaProductos = Arrays.asList(producto1, producto2);

        when(repository.findAll()).thenReturn(listaProductos);

        List<ProductosModel> resultado = controller.getProductos();

        assertEquals(2, resultado.size());
        assertEquals("Teclado", resultado.get(0).getNombreProducto());
        assertEquals(15, resultado.get(1).getStockProducto());
        verify(repository, times(1)).findAll();
    }
}
