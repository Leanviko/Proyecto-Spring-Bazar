package com.example.proyectobazar.service;

import com.example.proyectobazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    public void crearCliente(Cliente cliente);

    public List<Cliente> getCliente();

    public Cliente findCliente(Long id_cliente);

    public void eliminarCliente(Long id_cliente);

    public void editarCliente(Cliente cliente);
}
