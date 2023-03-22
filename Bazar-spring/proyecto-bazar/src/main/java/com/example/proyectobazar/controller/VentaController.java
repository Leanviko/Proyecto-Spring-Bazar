package com.example.proyectobazar.controller;

import com.example.proyectobazar.dto.MayorVentaDto;
import com.example.proyectobazar.model.Venta;
import com.example.proyectobazar.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "Venta guardada correctamente.";
    }

    @GetMapping("/ventas")
    public List<Venta> traerListaVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta) {
        return ventaService.findVenta(codigo_venta);
    }

    @GetMapping("/ventas/monto/{fecha_venta}")
    public String ventaMontoDiario(@PathVariable String fecha_venta) {
        return ventaService.ventaMontoDiario(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDto mayorVentaDto() {
        return ventaService.mayorVentaDto();

    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String borrarVenta(@PathVariable Long codigo_venta) {
        ventaService.eliminarVenta(codigo_venta);
        return "Venta borrada correctamente";
    }

    @PutMapping("/ventas/editar/")
    public String editarVenta(@RequestBody Venta venta) {
        ventaService.editarVenta(venta);
        return "Venta editada correctamente";
    }

}
