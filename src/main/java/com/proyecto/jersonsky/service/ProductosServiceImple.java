package com.proyecto.jersonsky.service;

import com.proyecto.jersonsky.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.jersonsky.repository.ProductosRepository;

import java.util.List;

@Service
public class ProductosServiceImple implements ProductosService {

    @Autowired
    ProductosRepository productosRepository;
    List<Productos> copialista;

    @Override
    public List<Productos> mostrarTodos() {
        return productosRepository.findAll() ;
    }

    @Override
    public Productos findById(Integer id) {
        var opCliente =  this.productosRepository.findById(id);
        if (opCliente.isPresent()) {
            return opCliente.get();
        } else {
            return new Productos();
        }
    }

    @Override
    public Productos crearProducto(Productos productos) {
        copialista = productosRepository.findAll();
        int finalLista = copialista.size();
        int idNuevoProducto = finalLista+1;
        productos.setProductoid(idNuevoProducto);
        return productosRepository.save(productos) ;
    }

    @Override
    public Productos actualizarProducto(Productos productos) {
        int ultimoProducto= productosRepository.findAll().size();
        if (productos.getProductoid()>0 && productos.getProductoid()<=ultimoProducto){
            return productosRepository.save(productos);
        }
        return null;
    }

    @Override
    public String borrarProducto(int id) {
        copialista= productosRepository.findAll();
        String texto = "No se encontro el producto con el id:"+id+", por lo tanto no se puede eliminar";
        if (id<1){return texto;}
        for(int i=0;i<copialista.size();i++){
            if (id==copialista.get(i).getProductoid()){
                texto = "El producto: "+copialista.get(i).getDescripcion()+", con el id: "+id+" ha sido eliminado ";
                productosRepository.deleteById(id);
                i=copialista.size();
            }
        }
        return texto;
    }
}
