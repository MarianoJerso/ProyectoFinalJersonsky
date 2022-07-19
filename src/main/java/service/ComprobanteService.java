package service;

import dto.ComprobanteDTO;
import model.Cliente;
import model.Comprobante;

import java.util.List;

public interface ComprobanteService {

    List <ComprobanteDTO> findAll();

    ComprobanteDTO findById(Integer id);

    ComprobanteDTO crearComprobanteDTO(Comprobante comprobante);












}
