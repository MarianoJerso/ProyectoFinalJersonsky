package com.proyecto.jersonsky.controller;

import com.proyecto.jersonsky.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.jersonsky.service.ProductosService;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;
    @GetMapping("")
    public List<Productos> mostrarTablaOriginal(){
        return productosService.mostrarTodos();
    }
    @GetMapping("/{id}")
    public Productos one(@PathVariable Integer id){
        return this.productosService.findById(id);
    }
    @PostMapping("*/crear")
    public Productos nuevoProducto(@RequestBody Productos productos){
        return productosService.crearProducto(productos);
    }
    @PostMapping("*/actualizar")
    public Productos actualizarProducto(@RequestBody Productos productos){
        return productosService.actualizarProducto(productos);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarProducto (@PathVariable int id){String texto =productosService.borrarProducto(id); return texto;
    }
}
