package com.example.proyectobazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MayorVentaDto {

    private Long codigo_venta;
    private int cantidad_productos;
    private Double total;
    private String nombre_cliente;
    private String apellico_cliente;

    public MayorVentaDto() {
    }

    public MayorVentaDto(Long codigo_venta, int cantidad_productos, Double total, String nombre_cliente, String apellico_cliente) {
        this.codigo_venta = codigo_venta;
        this.cantidad_productos = cantidad_productos;
        this.total = total;
        this.nombre_cliente = nombre_cliente;
        this.apellico_cliente = apellico_cliente;
    }

}
