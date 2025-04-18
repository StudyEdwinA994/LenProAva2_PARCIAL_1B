package com.universidad.proyectopersonal;

        import com.universidad.proyectopersonal.controller.ProductosController;
        import com.universidad.proyectopersonal.model.ProductosModel;
        import com.universidad.proyectopersonal.repository.ProductosRepository;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;

        import java.util.NoSuchElementException;
        import java.util.Optional;

        import static org.mockito.Mockito.*;
        import static org.junit.jupiter.api.Assertions.*;

public class EliminarProductosControllerTest {

    @Mock
    private ProductosRepository repository;

    @InjectMocks
    private ProductosController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEliminarProducto() {
        ProductosModel producto = new ProductosModel(1L, "Computador escritorio", 2000000.0f, "12 meses", 10);

        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        String resultado = controller.eliminarProducto(1L);

        assertEquals("¡Producto eliminado!", resultado);

        verify(repository, times(1)).delete(producto);
    }

    @Test
    public void testEliminarProductoNoEncontrado() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            controller.eliminarProducto(1L);
        });

        verify(repository, times(0)).delete(any(ProductosModel.class));
    }
}
