package com.universidad.proyectopersonal.controller;

import com.universidad.proyectopersonal.model.ProductosModel;
import com.universidad.proyectopersonal.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductosController {

    @Autowired
    private ProductosRepository repository;

    @GetMapping()
    public String inicioPpal (){
        return "La aplicación se ejecuta correctamente";
    }

    @GetMapping("productos")
    public List<ProductosModel> getProductos(){
        return repository.findAll();
    }

    @PostMapping("crearproducto")
    public String crearProducto(@RequestBody ProductosModel productosModel){
        repository.save(productosModel);
        return "¡Producto creado!";
    }

    @DeleteMapping("eliminarproducto/{id}")
    public String eliminarProducto(@PathVariable Long idProducto){
        ProductosModel borrarProducto = repository.findById(idProducto)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
        repository.delete(borrarProducto);
        return "¡Producto eliminado!";
    }


}
