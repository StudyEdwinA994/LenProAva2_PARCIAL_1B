package com.universidad.proyectopersonal;

import com.universidad.proyectopersonal.controller.ProductosController;
import com.universidad.proyectopersonal.model.ProductosModel;
import com.universidad.proyectopersonal.repository.ProductosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductosControllerUnitTest {

    @Mock
    private ProductosRepository repository;

    @InjectMocks
    private ProductosController controller;

    @Test
    public void testEliminarProducto() {
        ProductosModel producto = new ProductosModel(1L, "Computador escritorio", 2000000.0f, "12 meses", 10);

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(producto));

        controller.eliminarProducto(1L);

        verify(repository, times(1)).delete(producto);
    }

    @Test
    public void testEliminarProductoNoEncontrado() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            controller.eliminarProducto(1L);
        });
    }
}
