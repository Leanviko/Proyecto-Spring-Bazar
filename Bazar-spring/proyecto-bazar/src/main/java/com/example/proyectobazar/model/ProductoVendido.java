package com.example.proyectobazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductoVendido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_prod_vendido;
    private int cantidad_vendida;

    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    @JsonIgnoreProperties(value = "listaProductos")
    Venta venta;

    @OneToOne
    @JoinColumn(name = "codigo_producto")
    Producto producto;

    public ProductoVendido() {
    }

    public ProductoVendido(Long codigo_prod_vendido, int cantidad_vendida, Venta venta, Producto producto) {
        this.codigo_prod_vendido = codigo_prod_vendido;
        this.cantidad_vendida = cantidad_vendida;
        this.venta = venta;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ProductoVendido{" + "codigo_prod_vendido=" + codigo_prod_vendido + ", cantidad_vendida=" + cantidad_vendida + ", venta=" + venta + ", producto=" + producto + '}';
    }

}
