package com.example.proyectobazar.controller;

import com.example.proyectobazar.model.Producto;
import com.example.proyectobazar.service.IProductoService;
import com.example.proyectobazar.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService produService;
    @Autowired
    private IVentaService ventaService;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto) {
        produService.crearProducto(producto);
        return "Producto guardado correctamente.";
    }

    @GetMapping("/productos")
    public List<Producto> traerListaProd() {
        return produService.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProd(@PathVariable Long codigo_producto) {
        return produService.findProducto(codigo_producto);
    }

    @GetMapping("/productos/sinStock")
    public List<Producto> traerListaProdSinStock() {
        return produService.faltaStock();
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String borrarProducto(@PathVariable Long codigo_producto) {
        produService.eliminarProducto(codigo_producto);

        return "Producto borrado correctamente";
    }

    @PutMapping("/productos/editar/")
    public String editarProducto(@RequestBody Producto producto) {
        produService.editarProducto(producto);
        return "Producto editado correctamente";
    }

}
