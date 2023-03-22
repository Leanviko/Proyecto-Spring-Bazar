package com.example.proyectobazar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @OneToMany(mappedBy = "venta", orphanRemoval = true)
    @JsonIgnoreProperties(value = "venta")
    private List<ProductoVendido> listaProductos;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, List<ProductoVendido> ProductoVendido, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;

        this.listaProductos = ProductoVendido;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo_venta=" + codigo_venta + ", fecha_venta=" + fecha_venta + ", total=" + total + ", listaProductos=" + listaProductos + ", cliente=" + cliente + '}';
    }

}
