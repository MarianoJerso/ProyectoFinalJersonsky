package service;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

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

}
