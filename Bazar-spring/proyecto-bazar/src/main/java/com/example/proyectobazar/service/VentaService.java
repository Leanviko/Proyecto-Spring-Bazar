package com.example.proyectobazar.service;

import com.example.proyectobazar.dto.MayorVentaDto;
import com.example.proyectobazar.model.ProductoVendido;

import com.example.proyectobazar.model.Venta;
import com.example.proyectobazar.repository.IVentaRepository;
import java.time.LocalDate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Autowired
    private IProductoService proService;

    @Override
    public void crearVenta(Venta venta) {
        ventaRepo.save(venta);

    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void eliminarVenta(Long codigo_venta) {

        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editarVenta(Venta venta) {
        this.crearVenta(venta);
    }

    @Override
    public String ventaMontoDiario(String fecha_venta) {

        LocalDate fecha = LocalDate.parse(fecha_venta);

        List<Venta> ventasTodas = this.getVentas();//Traigo todas las ventas
        Double totalDiario = 0.0;
        int nVentas = 0;
        for (Venta v : ventasTodas) {
            if (v.getFecha_venta().equals(fecha)) {
                nVentas++;
                totalDiario += v.getTotal();
            }
        }
        return "El dia " + fecha_venta + " se realizaron " + nVentas + " venta/s por un monto total de " + totalDiario + " pesos";
    }

    @Override
    public void totalVenta(Venta venta) {

        List<ProductoVendido> productosVendidos = venta.getListaProductos(); //llega como null
        Venta vent = venta;
        Double totalVenta = 0.0;

        if (productosVendidos != null) {
            for (ProductoVendido p : productosVendidos) {
                totalVenta = totalVenta + (p.getProducto().getCosto() * p.getCantidad_vendida());
            }
        } else {
            System.out.println("----------La lista es nula--------");
        }

        vent.setTotal(totalVenta);

        this.editarVenta(vent);
    }

    @Override
    public MayorVentaDto mayorVentaDto() {

        List<Venta> ventas = this.getVentas();
        Double mayorMonto = 0.0;
        Venta mayorVenta = new Venta();

        for (Venta v : ventas) {
            if (v.getTotal() >= mayorMonto) {
                mayorMonto = v.getTotal();
                mayorVenta = v;
            }
        }

        MayorVentaDto mayorDto = new MayorVentaDto();

        mayorDto.setCodigo_venta(mayorVenta.getCodigo_venta());
        mayorDto.setCantidad_productos(mayorVenta.getListaProductos().size());
        mayorDto.setTotal(mayorVenta.getTotal());
        mayorDto.setNombre_cliente(mayorVenta.getCliente().getNombre());
        mayorDto.setApellico_cliente(mayorVenta.getCliente().getApellido());

        return mayorDto;
    }

}
