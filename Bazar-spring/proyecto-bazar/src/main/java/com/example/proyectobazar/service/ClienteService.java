package com.example.proyectobazar.service;

import com.example.proyectobazar.model.Cliente;
import com.example.proyectobazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getCliente() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return clienteRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        this.crearCliente(cliente);
    }

}
