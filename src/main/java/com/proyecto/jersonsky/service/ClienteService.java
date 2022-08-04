package com.proyecto.jersonsky.service;

import com.proyecto.jersonsky.model.Cliente;

import java.util.List;

public interface ClienteService {
    List <Cliente> mostrarTodos();

    Cliente findById(Integer id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    String borrarCliente(int id);
}
