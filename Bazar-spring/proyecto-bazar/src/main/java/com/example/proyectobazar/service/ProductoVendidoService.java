package com.example.proyectobazar.service;

import com.example.proyectobazar.model.Producto;
import com.example.proyectobazar.model.ProductoVendido;
import com.example.proyectobazar.model.Venta;
import com.example.proyectobazar.repository.IProductoVendidoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoVendidoService implements IProductoVendidoService {

    @Autowired
    private IProductoVendidoRepository proVenRepo;
    @Autowired
    private IProductoService proService;
    @Autowired
    private IVentaService ventaService;

    @Override
    public String crearProductoVendido(ProductoVendido productoVendido) {

        if (setStock(productoVendido)) {
            Long codVenta = productoVendido.getVenta().getCodigo_venta();
            Venta venta = ventaService.findVenta(codVenta);
            proVenRepo.save(productoVendido);

            ventaService.totalVenta(venta);
            //setStock(productoVendido);

            return "Producto vendido registrado correctamente.";
        } else {
            return "Stock insuficiente, registro cancelado";
        }

    }

    public boolean setStock(ProductoVendido productoVendido) {
        Long CodProducto = productoVendido.getProducto().getCodigo_producto();
        Producto producto = proService.findProducto(CodProducto);
        int stock = producto.getCantidad_disponible() - productoVendido.getCantidad_vendida();
        boolean guardado = false;

        if (stock >= 0) {
            producto.setCantidad_disponible(stock);
            proService.editarProducto(producto);
            guardado = true;
        }
        return guardado;
    }

    @Override
    public List<ProductoVendido> getProductosVendidos() {
        return proVenRepo.findAll();
    }

    @Override
    public ProductoVendido findProductoVendido(Long codigo_producto) {
        return proVenRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void eliminarProductoVendido(Long codigo_producto) {
        Venta venta = this.findProductoVendido(codigo_producto).getVenta();
        proVenRepo.deleteById(codigo_producto);
        ventaService.totalVenta(venta);
    }

    @Override
    public void editarProductoVendido(ProductoVendido productoVend) {

        this.crearProductoVendido(productoVend);
    }

    @Override
    public List<ProductoVendido> traerProdPorVenta(Long codigo_venta) {
        List<ProductoVendido> ProductosVendidos = this.getProductosVendidos();
        List<ProductoVendido> ProductosVenta = new ArrayList<>();

        for (ProductoVendido p : ProductosVendidos) {
            if (Objects.equals(p.getVenta().getCodigo_venta(), codigo_venta)) {
                ProductosVenta.add(p);
            }
        }
        return ProductosVenta;
    }

}
