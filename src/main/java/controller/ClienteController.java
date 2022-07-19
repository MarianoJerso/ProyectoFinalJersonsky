package controller;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import java.util.List;

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
}
