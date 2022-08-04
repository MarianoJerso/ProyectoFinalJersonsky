package com.proyecto.jersonsky.controller;

import com.proyecto.jersonsky.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.jersonsky.service.ClienteService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public List<Cliente> mostrarTablaOriginal(){
        return clienteService.mostrarTodos() ;
    }
    @GetMapping("/{id}")
    public Cliente one(@PathVariable Integer id) {

        return this.clienteService.findById(id);
    }

    @PostMapping("*/crear")
    public Cliente nuevoCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }
    @PostMapping("*/actualizar")
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.actualizarCliente(cliente);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarCliente (@PathVariable int id){String texto =clienteService.borrarCliente(id); return texto;
        }
    }



