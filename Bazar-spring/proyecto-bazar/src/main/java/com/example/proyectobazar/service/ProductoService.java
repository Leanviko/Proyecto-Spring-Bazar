package com.example.proyectobazar.service;

import com.example.proyectobazar.model.Producto;
import com.example.proyectobazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository produRepo;

    @Override
    public void crearProducto(Producto producto) {
        produRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return produRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void eliminarProducto(Long codigo_producto) {
        produRepo.deleteById(codigo_producto);
    }

    @Override
    public void editarProducto(Producto producto) {
        this.crearProducto(producto);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> Productos = this.getProductos();
        List<Producto> pocoStock = new ArrayList<>();

        for (Producto p : Productos) {
            if (p.getCantidad_disponible() < 5) {
                pocoStock.add(p);
            }
        }

        return pocoStock;
    }

}
