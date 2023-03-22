package com.example.proyectobazar.service;

import com.example.proyectobazar.model.ProductoVendido;
import java.util.List;

public interface IProductoVendidoService {

    public String crearProductoVendido(ProductoVendido productovend);

    public List<ProductoVendido> getProductosVendidos();

    public ProductoVendido findProductoVendido(Long codigo_producto);

    public void eliminarProductoVendido(Long codigo_producto);

    public void editarProductoVendido(ProductoVendido productovend);

    public List<ProductoVendido> traerProdPorVenta(Long codigo_venta);
}
