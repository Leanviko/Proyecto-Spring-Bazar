
package com.example.proyectobazar.controller;


import com.example.proyectobazar.model.Cliente;
import com.example.proyectobazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClienteController {
 @Autowired
    private IClienteService clienteService;
    
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteService.crearCliente(cliente);
        return "Cliente guardado correctamente.";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> traerListaCliente(){
        return clienteService.getCliente();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return clienteService.findCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String borrarCliente(@PathVariable Long id_cliente){
        clienteService.eliminarCliente(id_cliente);
        return "Cliente borrado correctamente";
    }
    
    @PutMapping("/clientes/editar/")
    public String editarVenta(@RequestBody Cliente cliente){
        clienteService.editarCliente(cliente);
        return "Venta editada correctamente";
    }    
}
