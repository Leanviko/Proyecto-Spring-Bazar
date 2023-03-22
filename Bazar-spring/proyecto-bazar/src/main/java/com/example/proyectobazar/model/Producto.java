package com.example.proyectobazar.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private int cantidad_disponible;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, int cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad_disponible=" + cantidad_disponible + '}';
    }

}
