package com.proyecto.jersonsky.service;

import com.proyecto.jersonsky.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.jersonsky.repository.ClienteRepository;
import java.util.Iterator;
import java.util.List;

@Service
public class ClienteServiceImple implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    List<Cliente> copialista;

    @Override
    public List<Cliente> mostrarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        var opCliente =  this.clienteRepository.findById(id);
        if (opCliente.isPresent()) {
            return opCliente.get();
        } else {
            return new Cliente();
        }
    }
    @Override
    public Cliente crearCliente(Cliente cliente) {
        copialista = clienteRepository.findAll();
        int finalLista = copialista.size();
        int idNuevoCliente = finalLista+1;
        cliente.setClienteid(idNuevoCliente);
        return clienteRepository.save(cliente) ;   }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        int ultimoCliente= clienteRepository.findAll().size();
        if (cliente.getClienteid()>0 && cliente.getClienteid()<=ultimoCliente){
            return clienteRepository.save(cliente);
        }
        return null ;
    }

    @Override
    public String borrarCliente(int id) {
        copialista= clienteRepository.findAll();
        String texto = "No se encontro el cliente con el id:"+id+", por lo tanto no se puede eliminar";
        if (id<1){return texto;}
        for(int i=0;i<copialista.size();i++){
            if (id==copialista.get(i).getClienteid()){
                clienteRepository.deleteById(id);
                texto = "El cliente con el id: "+ id +" ha sido eliminado";
                i=copialista.size();
            }
        }
        return texto;
    }


}
