package controller;
import java.util.List;

import dto.ComprobanteDTO;
import model.Comprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ComprobanteServiceImplem;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteServiceImplem comprobanteServiceImplem;

    @GetMapping
    public List<ComprobanteDTO> mostrarTablaOriginal() {
        return this.comprobanteServiceImplem.findAll();
    }

    // Single item

    @GetMapping("/{id}")
    public ComprobanteDTO one(@PathVariable Integer id) {

        return this.comprobanteServiceImplem.findById(id);
    }

    @PostMapping
    public ComprobanteDTO nuevoCliente (@RequestBody Comprobante comprobante) {
        return this.comprobanteServiceImplem.save(comprobante);
    }
}
