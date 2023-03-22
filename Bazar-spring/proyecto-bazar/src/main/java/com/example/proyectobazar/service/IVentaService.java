package com.example.proyectobazar.service;

import com.example.proyectobazar.dto.MayorVentaDto;
import com.example.proyectobazar.model.Venta;
import java.util.List;

public interface IVentaService {

    public void crearVenta(Venta venta);

    public List<Venta> getVentas();

    public Venta findVenta(Long codigo_venta);

    public void eliminarVenta(Long codigo_venta);

    public void editarVenta(Venta venta);

    public void totalVenta(Venta venta);

    public String ventaMontoDiario(String fecha_venta);

    public MayorVentaDto mayorVentaDto();

}
