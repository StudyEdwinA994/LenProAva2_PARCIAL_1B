package com.universidad.proyectopersonal.repository;

import com.universidad.proyectopersonal.model.ProductosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<ProductosModel, Long> {

}
