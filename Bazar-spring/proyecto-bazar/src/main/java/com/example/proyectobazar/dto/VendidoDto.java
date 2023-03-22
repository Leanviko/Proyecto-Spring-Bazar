package com.example.proyectobazar.dto;

import com.example.proyectobazar.model.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendidoDto {

    private String nombre;
    private String marca;
    private Double costo;
    private int cantidad_vendida;
    Producto producto;

    public VendidoDto() {
    }

    public VendidoDto(String nombre, String marca, Double costo, int cantidad_vendida, Producto producto) {
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_vendida = cantidad_vendida;
        this.producto = producto;
    }
}
