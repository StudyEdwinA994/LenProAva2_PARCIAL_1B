package com.universidad.proyectopersonal.model;

import jakarta.persistence.*;

@Entity
public class ProductosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column
    private String nombreProducto;

    @Column
    private float precioProducto;

    @Column
    private String garantiaProducto;

    @Column
    private int stockProducto;

    public ProductosModel() {
    }

    public ProductosModel(Long idProducto, String nombreProducto, float precioProducto, String garantiaProducto, int stockProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.garantiaProducto = garantiaProducto;
        this.stockProducto = stockProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getGarantiaProducto() {
        return garantiaProducto;
    }

    public void setGarantiaProducto(String garantiaProducto) {
        this.garantiaProducto = garantiaProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

}
