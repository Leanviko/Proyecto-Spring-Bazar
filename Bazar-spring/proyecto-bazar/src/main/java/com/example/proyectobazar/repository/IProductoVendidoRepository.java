package com.example.proyectobazar.repository;

import com.example.proyectobazar.model.ProductoVendido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoVendidoRepository extends JpaRepository<ProductoVendido, Long> {

}
