package com.example.proyectobazar.controller;

import com.example.proyectobazar.model.ProductoVendido;

import com.example.proyectobazar.service.IProductoService;
import com.example.proyectobazar.service.IProductoVendidoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoVendidoController {

    @Autowired
    private IProductoVendidoService produVendService;
    @Autowired
    private IProductoService produService;

    @PostMapping("/productosVendidos/crear")
    public String crearProducto(@RequestBody ProductoVendido productoVendido) {

        return produVendService.crearProductoVendido(productoVendido);

    }

    @GetMapping("/productosVendidos")
    public List<ProductoVendido> traerListaProd() {
        return produVendService.getProductosVendidos();
    }

    @GetMapping("/productosVendidos/porVenta/{codigo_venta}")
    public List<ProductoVendido> traerListaProd(@PathVariable Long codigo_venta) {
        return produVendService.traerProdPorVenta(codigo_venta);
    }

    @GetMapping("/productosVendidos/{codigo_prod_vendido}")
    public ProductoVendido traerProd(@PathVariable Long codigo_prod_vendido) {
        return produVendService.findProductoVendido(codigo_prod_vendido);
    }

    @DeleteMapping("/productosVendidos/eliminar/{codigo_prod_vendido}")
    public String borrarProducto(@PathVariable Long codigo_prod_vendido) {

        produVendService.eliminarProductoVendido(codigo_prod_vendido);

        return "Producto vendido borrado correctamente";
    }

    @PutMapping("/productosVendidos/editar/")
    public String editarProducto(@RequestBody ProductoVendido productoVendido) {
        produVendService.editarProductoVendido(productoVendido);

        return "Producto vendido editado correctamente";
    }
}
