package com.proyecto.jersonsky.service;

import com.proyecto.jersonsky.model.Productos;

import java.util.List;
public interface ProductosService {

    List<Productos> mostrarTodos();

    Productos findById(Integer id);

    Productos crearProducto (Productos productos);

    Productos actualizarProducto(Productos productos);

    String borrarProducto (int id);
}
