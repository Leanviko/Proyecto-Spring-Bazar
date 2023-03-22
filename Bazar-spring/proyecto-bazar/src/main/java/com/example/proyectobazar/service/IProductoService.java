package com.example.proyectobazar.service;

import com.example.proyectobazar.model.Producto;
import java.util.List;

public interface IProductoService {

    public void crearProducto(Producto producto);

    public List<Producto> getProductos();

    public Producto findProducto(Long codigo_producto);

    public void eliminarProducto(Long codigo_producto);

    public void editarProducto(Producto producto);

    public List<Producto> faltaStock();

}
