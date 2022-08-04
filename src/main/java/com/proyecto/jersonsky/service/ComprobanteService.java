package com.proyecto.jersonsky.service;

import com.proyecto.jersonsky.dto.ComprobanteDTO;
import com.proyecto.jersonsky.model.Comprobante;

import java.util.List;

public interface ComprobanteService {

    List <ComprobanteDTO> findAll();

    ComprobanteDTO findById(Integer id);

    ComprobanteDTO crearComprobanteDTO(Comprobante comprobante);












}
